package lo2;

import android.text.TextUtils;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import com.tencent.qqnt.kernel.nativeinterface.UfsResultItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class s extends m {

    /* renamed from: b0, reason: collision with root package name */
    public String f415269b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f415270c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f415271d0;

    /* renamed from: e0, reason: collision with root package name */
    public List<String> f415272e0;

    /* renamed from: f0, reason: collision with root package name */
    public String f415273f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f415274g0;

    public s(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
        this.f415274g0 = false;
        this.f283549m = false;
        if (unifySearchCommon$ResultItem.name.has()) {
            this.f415270c0 = unifySearchCommon$ResultItem.name.get().toStringUtf8();
        }
        if (unifySearchCommon$ResultItem.pic_url.has()) {
            this.f415271d0 = unifySearchCommon$ResultItem.pic_url.get().toStringUtf8();
        }
        if (unifySearchCommon$ResultItem.jmp_url.has()) {
            this.f415273f0 = unifySearchCommon$ResultItem.jmp_url.get().toStringUtf8();
        }
        C(23);
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f415269b0 = jSONObject.optString("appid");
            JSONArray optJSONArray = jSONObject.optJSONArray(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
            if (optJSONArray != null) {
                this.f415272e0 = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i3))) {
                        this.f415272e0.add(optJSONArray.optString(i3));
                    }
                }
            }
        } catch (JSONException e16) {
            QLog.e("NetSearchTemplateGameItem", 1, "parseLayoutExtensions exception:", e16);
        }
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        return this.f415270c0;
    }

    public s(String str, long j3, List<String> list, UfsResultItem ufsResultItem, int i3) {
        super(str, j3, list, ufsResultItem, i3);
        this.f415274g0 = false;
        this.f283549m = false;
        this.f415270c0 = ufsResultItem.name;
        this.f415271d0 = ufsResultItem.picUrl;
        this.f415273f0 = ufsResultItem.jmpUrl;
        C(23);
    }
}
