package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchDiscovery$GuessWantItem;
import pb.unify.search.UnifySearchDiscovery$Result;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GuessSearchEntryDataModel extends SearchEntryDataModel {
    private final CopyOnWriteArrayList<GuessSearchItem> D;
    private String E;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class GuessSearchItem implements Serializable {
        public String extension;
        public String jumpUrl;
        public String reportData;
        public String tagBgColor;
        public String tagColor;
        public String tagText;
        public int type;
        public String word;
    }

    public GuessSearchEntryDataModel(int i3, int i16) {
        super(i3, i16);
        this.D = new CopyOnWriteArrayList<>();
    }

    @Override // com.tencent.mobileqq.search.model.SearchEntryDataModel
    public void k(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        UnifySearchDiscovery$Result unifySearchDiscovery$Result = new UnifySearchDiscovery$Result();
        try {
            unifySearchDiscovery$Result.mergeFrom(bArr);
            if (!unifySearchDiscovery$Result.guess_want_items.has()) {
                return;
            }
            this.E = unifySearchDiscovery$Result.guess_want_items.title.get();
            List<UnifySearchDiscovery$GuessWantItem> list = unifySearchDiscovery$Result.guess_want_items.items.get();
            this.D.clear();
            if (list == null) {
                return;
            }
            for (UnifySearchDiscovery$GuessWantItem unifySearchDiscovery$GuessWantItem : list) {
                GuessSearchItem guessSearchItem = new GuessSearchItem();
                guessSearchItem.word = unifySearchDiscovery$GuessWantItem.word.get().toStringUtf8();
                guessSearchItem.extension = unifySearchDiscovery$GuessWantItem.extension.get().toStringUtf8();
                guessSearchItem.reportData = unifySearchDiscovery$GuessWantItem.reportData.get().toStringUtf8();
                guessSearchItem.type = unifySearchDiscovery$GuessWantItem.type.get();
                q(guessSearchItem);
                this.D.add(guessSearchItem);
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SearchEntryDataModel", 2, "[fabricateModel] InvalidProtocolBufferMicroException e = " + e16);
            }
            this.D.clear();
        }
    }

    public List<GuessSearchItem> o() {
        return this.D;
    }

    public String p() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(GuessSearchItem guessSearchItem) {
        if (!TextUtils.isEmpty(guessSearchItem.extension)) {
            try {
                JSONObject jSONObject = new JSONObject(guessSearchItem.extension);
                guessSearchItem.tagText = jSONObject.optString("text");
                guessSearchItem.tagColor = jSONObject.optString("color");
                guessSearchItem.tagBgColor = jSONObject.optString("background");
                guessSearchItem.jumpUrl = jSONObject.optString("jump_url");
            } catch (JSONException e16) {
                QLog.e("SearchEntryDataModel", 2, "[parseExtension] JSONException e = " + e16);
            }
        }
    }

    public void r(String str) {
        this.E = str;
    }
}
