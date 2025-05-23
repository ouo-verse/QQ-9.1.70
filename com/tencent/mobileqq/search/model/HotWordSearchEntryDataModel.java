package com.tencent.mobileqq.search.model;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import circlesearch.CircleSearchExhibition$UnifySearchResultExt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchDiscovery$HotSearchItem;
import pb.unify.search.UnifySearchDiscovery$Result;
import pb.unify.search.UnifySearchDiscovery$TitleHeaderItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class HotWordSearchEntryDataModel extends SearchEntryDataModel {
    protected static final Object K = new Object();
    public final int D;
    public final CopyOnWriteArrayList<HotSearchItem> E;
    public final a F;
    public final GIFInfo G;
    public String H;
    public int I;
    private UnifySearchDiscovery$Result J;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class GIFInfo implements Serializable {
        public String hotSearchGifID;
        public String hotSearchGifUrl;
        public String hotSearchGifUrlNight;
        public String hotWordGifUrl;
        public String hotWordGifUrlNight;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class HotSearchItem implements Serializable {
        public String badgeUrl;
        public String countText;
        public String detailText;
        public String imgBgUrl;
        public String imgUrl;
        public String indexBgColor;
        public String indexTextColor;
        public String jumpUrl;
        public String recallWord;
        public String rightIconUrl;
        public String sAppend;
        public String sExtInfo;
        public int showCount;
        public int showType;
        public String tagBGColor;
        public String tagColor;
        public String tagInfo;
        public String title;
        public String titleTextColor;
        public int type;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f283449a;

        /* renamed from: b, reason: collision with root package name */
        public String f283450b;

        /* renamed from: c, reason: collision with root package name */
        public String f283451c;

        /* renamed from: d, reason: collision with root package name */
        public String f283452d;

        /* renamed from: e, reason: collision with root package name */
        public int f283453e;

        /* renamed from: f, reason: collision with root package name */
        public String f283454f;

        public a() {
        }
    }

    public HotWordSearchEntryDataModel(int i3, int i16, boolean z16) {
        super(i3, i16);
        this.D = 15;
        this.E = new CopyOnWriteArrayList<>();
        this.F = new a();
        this.G = new GIFInfo();
    }

    public static CircleSearchExhibition$UnifySearchResultExt o(UnifySearchDiscovery$Result unifySearchDiscovery$Result) {
        if (unifySearchDiscovery$Result != null && unifySearchDiscovery$Result.result_ext.has()) {
            byte[] byteArray = unifySearchDiscovery$Result.result_ext.get().toByteArray();
            CircleSearchExhibition$UnifySearchResultExt circleSearchExhibition$UnifySearchResultExt = new CircleSearchExhibition$UnifySearchResultExt();
            try {
                circleSearchExhibition$UnifySearchResultExt.mergeFrom(byteArray);
                return circleSearchExhibition$UnifySearchResultExt;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.w("SearchEntryDataModel", 1, e16.getMessage(), e16);
                return null;
            }
        }
        return null;
    }

    private List<HotSearchItem> t(int i3) {
        int i16;
        boolean z16;
        synchronized (K) {
            if (this.E.size() != 0) {
                if (UniteSearchActivity.f282686d0 != null) {
                    i16 = 0;
                    while (i16 < this.E.size()) {
                        if (TextUtils.equals(this.E.get(i16).title, UniteSearchActivity.f282686d0.title)) {
                            z16 = true;
                            break;
                        }
                        i16++;
                    }
                }
                i16 = 0;
                z16 = false;
                int i17 = i16 + i3;
                if (i17 > this.E.size()) {
                    i17 = this.E.size();
                }
                ArrayList arrayList = new ArrayList(this.E.subList(i16, i17));
                int i18 = 0;
                for (int size = arrayList.size(); i18 < this.E.size() - 1 && size < i3; size++) {
                    arrayList.add(this.E.get(i18));
                    i18++;
                }
                if (UniteSearchActivity.f282686d0 != null && !z16 && arrayList.size() > 0) {
                    arrayList.set(0, UniteSearchActivity.f282686d0);
                }
                return arrayList;
            }
            return null;
        }
    }

    public static boolean u(int i3, boolean z16) {
        long j3;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        if (runtime == null) {
            return false;
        }
        if (!z16) {
            j3 = defaultSharedPreferences.getLong("search_discovery_sp_prefixlast_update_time" + runtime.getAccount() + "_" + i3, 0L);
        } else {
            j3 = defaultSharedPreferences.getLong("search_discovery_sp_prefix_unifylast_update_time" + runtime.getAccount() + "_" + i3, 0L);
        }
        if (System.currentTimeMillis() - j3 <= 86400000) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.search.model.SearchEntryDataModel
    public void k(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        UnifySearchDiscovery$Result unifySearchDiscovery$Result = new UnifySearchDiscovery$Result();
        this.J = unifySearchDiscovery$Result;
        try {
            unifySearchDiscovery$Result.mergeFrom(bArr);
            List<UnifySearchDiscovery$HotSearchItem> list = this.J.hot_search_items.get();
            UnifySearchDiscovery$TitleHeaderItem unifySearchDiscovery$TitleHeaderItem = this.J.title_header.get();
            this.F.f283450b = unifySearchDiscovery$TitleHeaderItem.icon_url.get().toStringUtf8();
            this.F.f283449a = unifySearchDiscovery$TitleHeaderItem.title.get().toStringUtf8();
            this.F.f283451c = unifySearchDiscovery$TitleHeaderItem.morn_text.get().toStringUtf8();
            this.F.f283452d = unifySearchDiscovery$TitleHeaderItem.morn_url.get().toStringUtf8();
            this.F.f283453e = unifySearchDiscovery$TitleHeaderItem.header_type.get();
            if (unifySearchDiscovery$TitleHeaderItem.qq_index_jump_url.has()) {
                this.F.f283454f = unifySearchDiscovery$TitleHeaderItem.qq_index_jump_url.get().toStringUtf8();
            }
            this.E.clear();
            if (!u(this.f283457h, true)) {
                for (UnifySearchDiscovery$HotSearchItem unifySearchDiscovery$HotSearchItem : list) {
                    HotSearchItem hotSearchItem = new HotSearchItem();
                    hotSearchItem.title = unifySearchDiscovery$HotSearchItem.title.get().toStringUtf8();
                    hotSearchItem.type = this.J.type.get();
                    hotSearchItem.showType = unifySearchDiscovery$HotSearchItem.show_type.get();
                    hotSearchItem.showCount = unifySearchDiscovery$HotSearchItem.wz_ts.get();
                    hotSearchItem.sExtInfo = unifySearchDiscovery$HotSearchItem.item_ext.get().toStringUtf8();
                    String stringUtf8 = unifySearchDiscovery$HotSearchItem.recall_word.get().toStringUtf8();
                    if (TextUtils.isEmpty(stringUtf8)) {
                        stringUtf8 = hotSearchItem.title;
                    }
                    hotSearchItem.recallWord = stringUtf8;
                    hotSearchItem.imgUrl = unifySearchDiscovery$HotSearchItem.img_url.get().toStringUtf8();
                    hotSearchItem.detailText = unifySearchDiscovery$HotSearchItem.detail_text.get().toStringUtf8();
                    hotSearchItem.jumpUrl = unifySearchDiscovery$HotSearchItem.jump_url.get().toStringUtf8();
                    hotSearchItem.indexTextColor = unifySearchDiscovery$HotSearchItem.mark_text_color.get().toStringUtf8();
                    hotSearchItem.indexBgColor = unifySearchDiscovery$HotSearchItem.mark_bg_color.get().toStringUtf8();
                    hotSearchItem.imgBgUrl = unifySearchDiscovery$HotSearchItem.img_bg_url.get().toStringUtf8();
                    hotSearchItem.titleTextColor = unifySearchDiscovery$HotSearchItem.text_color.get().toStringUtf8();
                    hotSearchItem.rightIconUrl = unifySearchDiscovery$HotSearchItem.right_icon_url.get().toStringUtf8();
                    if (!TextUtils.isEmpty(hotSearchItem.sExtInfo)) {
                        try {
                            JSONObject optJSONObject = new JSONObject(hotSearchItem.sExtInfo).optJSONObject("label");
                            if (optJSONObject != null) {
                                hotSearchItem.tagColor = optJSONObject.optString("color");
                                hotSearchItem.tagInfo = optJSONObject.optString("text");
                                hotSearchItem.tagBGColor = optJSONObject.optString("background");
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    synchronized (K) {
                        this.E.add(hotSearchItem);
                    }
                }
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SearchEntryDataModel", 2, "fabricateModel, InvalidProtocolBufferMicroException e = " + e16);
            }
        }
        QLog.d("SearchEntryDataModel818searchProto_new", 2, "fabricateModel");
    }

    public void p(HotSearchItem hotSearchItem) {
        if (hotSearchItem == null) {
            return;
        }
        this.E.remove(hotSearchItem);
        UnifySearchDiscovery$Result unifySearchDiscovery$Result = this.J;
        if (unifySearchDiscovery$Result == null) {
            return;
        }
        int size = unifySearchDiscovery$Result.hot_search_items.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (TextUtils.equals(hotSearchItem.title, this.J.hot_search_items.get(i3).title.get().toStringUtf8())) {
                this.J.hot_search_items.remove(i3);
                this.f283458i = this.J.toByteArray();
                n();
                return;
            }
        }
    }

    public List<HotSearchItem> q() {
        int i3 = this.I;
        if (i3 <= 0) {
            i3 = 15;
        }
        return t(i3);
    }

    public CircleSearchExhibition$UnifySearchResultExt r() {
        return o(this.J);
    }

    public List<HotSearchItem> s() {
        if (this.f283456f == 1) {
            return this.E;
        }
        return t(nn2.a.f420533d);
    }

    public void v(HotSearchItem hotSearchItem) {
        UnifySearchDiscovery$Result unifySearchDiscovery$Result;
        if (hotSearchItem == null || (unifySearchDiscovery$Result = this.J) == null) {
            return;
        }
        int size = unifySearchDiscovery$Result.hot_search_items.size();
        for (int i3 = 0; i3 < size; i3++) {
            UnifySearchDiscovery$HotSearchItem unifySearchDiscovery$HotSearchItem = this.J.hot_search_items.get(i3);
            if (TextUtils.equals(hotSearchItem.title, unifySearchDiscovery$HotSearchItem.title.get().toStringUtf8())) {
                unifySearchDiscovery$HotSearchItem.item_ext.set(ByteStringMicro.copyFromUtf8(hotSearchItem.sExtInfo));
                this.f283458i = this.J.toByteArray();
                n();
                return;
            }
        }
    }
}
