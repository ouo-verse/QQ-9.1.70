package com.tencent.aelight.camera.ae.flashshow.ui;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0002\u0017\u001aB\u0007\u00a2\u0006\u0004\b \u0010!J$\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0003J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R2\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/ay;", "Lcom/tencent/aelight/camera/ae/control/b;", "Ljava/util/HashMap;", "", "Lcom/tencent/aelight/camera/ae/flashshow/ui/ay$a;", "Lkotlin/collections/HashMap;", "f", "Lcom/tencent/aelight/camera/ae/flashshow/ui/ay$b;", "g", "d", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "filterMaterial", "", "k", ITroopAnnouncementHelperApi.CONTROL_INFO_FILTER_ID, "filterData", "j", "Ljava/lang/Runnable;", "runnable", "e", "c", "onInit", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "a", "Lcom/tencent/aelight/camera/ae/flashshow/ui/ay$b;", "selectedFilter", "b", "Ljava/util/HashMap;", "filterDataMap", "Ljava/lang/Runnable;", "saveFilterDataRunnable", "saveSelectFilterRunnable", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ay extends com.tencent.aelight.camera.ae.control.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private SelectFilter selectedFilter = g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, FilterData> filterDataMap = f();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Runnable saveFilterDataRunnable = new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.aw
        @Override // java.lang.Runnable
        public final void run() {
            ay.h(ay.this);
        }
    };

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Runnable saveSelectFilterRunnable = new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ax
        @Override // java.lang.Runnable
        public final void run() {
            ay.i(ay.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001\u00a8\u0006\u0006"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/ay$c", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "Lcom/tencent/aelight/camera/ae/flashshow/ui/ay$a;", "Lkotlin/collections/HashMap;", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c extends TypeToken<HashMap<String, FilterData>> {
        c() {
        }
    }

    private final HashMap<String, FilterData> f() {
        try {
            HashMap<String, FilterData> hashMap = (HashMap) new Gson().fromJson(com.tencent.mobileqq.wink.utils.ar.f326685a.i("ae_key_editor_camera_filter_data", ""), new c().getType());
            return hashMap == null ? new HashMap<>() : hashMap;
        } catch (JsonSyntaxException unused) {
            return new HashMap<>();
        }
    }

    private final SelectFilter g() {
        try {
            return (SelectFilter) new Gson().fromJson(com.tencent.mobileqq.wink.utils.ar.f326685a.i("ae_key_editor_camera_selected_filter_id", ""), SelectFilter.class);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ay this$0) {
        String jsonString;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0.filterDataMap) {
            jsonString = new Gson().toJson(this$0.filterDataMap);
        }
        com.tencent.mobileqq.wink.utils.ar arVar = com.tencent.mobileqq.wink.utils.ar.f326685a;
        Intrinsics.checkNotNullExpressionValue(jsonString, "jsonString");
        arVar.r("ae_key_editor_camera_filter_data", jsonString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ay this$0) {
        String targetString;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0) {
            try {
                targetString = new Gson().toJson(this$0.selectedFilter);
            } catch (Exception unused) {
                targetString = "";
            }
            com.tencent.mobileqq.wink.utils.ar arVar = com.tencent.mobileqq.wink.utils.ar.f326685a;
            Intrinsics.checkNotNullExpressionValue(targetString, "targetString");
            arVar.r("ae_key_editor_camera_selected_filter_id", targetString);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final FilterData c(String filterID) {
        FilterData filterData;
        Intrinsics.checkNotNullParameter(filterID, "filterID");
        synchronized (this.filterDataMap) {
            filterData = this.filterDataMap.get(filterID);
        }
        return filterData;
    }

    public final SelectFilter d() {
        SelectFilter selectFilter;
        synchronized (this) {
            selectFilter = this.selectedFilter;
        }
        return selectFilter;
    }

    public final void e(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadManager.getFileThreadHandler().removeCallbacks(runnable);
        ThreadManager.getFileThreadHandler().post(runnable);
    }

    public final void j(String filterID, FilterData filterData) {
        Intrinsics.checkNotNullParameter(filterID, "filterID");
        Intrinsics.checkNotNullParameter(filterData, "filterData");
        synchronized (this.filterDataMap) {
            this.filterDataMap.put(filterID, filterData);
            Unit unit = Unit.INSTANCE;
        }
        e(this.saveFilterDataRunnable);
    }

    public final void k(MetaMaterial filterMaterial) {
        SelectFilter selectFilter;
        synchronized (this) {
            if (filterMaterial != null) {
                try {
                    String str = filterMaterial.f30533id;
                    Intrinsics.checkNotNullExpressionValue(str, "it.id");
                    String str2 = filterMaterial.thumbUrl;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.thumbUrl");
                    String str3 = filterMaterial.packageUrl;
                    Intrinsics.checkNotNullExpressionValue(str3, "it.packageUrl");
                    selectFilter = new SelectFilter(str, str2, str3, com.tencent.mobileqq.wink.editor.filter.f.k(filterMaterial));
                } catch (Throwable th5) {
                    throw th5;
                }
            } else {
                selectFilter = null;
            }
            this.selectedFilter = selectFilter;
            Unit unit = Unit.INSTANCE;
        }
        e(this.saveSelectFilterRunnable);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/ay$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "seekBarValue", "I", "a", "()I", "setSeekBarValue", "(I)V", "<init>", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.ui.ay$a, reason: from toString */
    /* loaded from: classes32.dex */
    public static final /* data */ class FilterData {

        @SerializedName("seek_bar_value")
        private int seekBarValue;

        public FilterData(int i3) {
            this.seekBarValue = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getSeekBarValue() {
            return this.seekBarValue;
        }

        public int hashCode() {
            return this.seekBarValue;
        }

        public String toString() {
            return "FilterData(seekBarValue=" + this.seekBarValue + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FilterData) && this.seekBarValue == ((FilterData) other).seekBarValue;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/ay$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "id", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "packageUrl", "getPackageUrl", "setPackageUrl", "lutPath", "b", "setLutPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.ui.ay$b, reason: from toString */
    /* loaded from: classes32.dex */
    public static final /* data */ class SelectFilter {

        @SerializedName("id")
        private String id;

        @SerializedName("lutPath")
        private String lutPath;

        @SerializedName("packageUrl")
        private String packageUrl;

        @SerializedName("thumbUrl")
        private String thumbUrl;

        public SelectFilter(String id5, String thumbUrl, String packageUrl, String lutPath) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
            Intrinsics.checkNotNullParameter(packageUrl, "packageUrl");
            Intrinsics.checkNotNullParameter(lutPath, "lutPath");
            this.id = id5;
            this.thumbUrl = thumbUrl;
            this.packageUrl = packageUrl;
            this.lutPath = lutPath;
        }

        /* renamed from: a, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: b, reason: from getter */
        public final String getLutPath() {
            return this.lutPath;
        }

        public int hashCode() {
            return (((((this.id.hashCode() * 31) + this.thumbUrl.hashCode()) * 31) + this.packageUrl.hashCode()) * 31) + this.lutPath.hashCode();
        }

        public String toString() {
            return "SelectFilter(id=" + this.id + ", thumbUrl=" + this.thumbUrl + ", packageUrl=" + this.packageUrl + ", lutPath=" + this.lutPath + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectFilter)) {
                return false;
            }
            SelectFilter selectFilter = (SelectFilter) other;
            return Intrinsics.areEqual(this.id, selectFilter.id) && Intrinsics.areEqual(this.thumbUrl, selectFilter.thumbUrl) && Intrinsics.areEqual(this.packageUrl, selectFilter.packageUrl) && Intrinsics.areEqual(this.lutPath, selectFilter.lutPath);
        }
    }

    @Override // com.tencent.aelight.camera.ae.control.b
    public void onDestroy() {
    }

    @Override // com.tencent.aelight.camera.ae.control.b
    public void onInit() {
    }
}
