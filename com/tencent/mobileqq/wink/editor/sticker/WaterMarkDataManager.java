package com.tencent.mobileqq.wink.editor.sticker;

import androidx.fragment.app.Fragment;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.model.WinkUserInfo;
import com.tencent.mobileqq.wink.editor.sticker.WaterMarkDataManager;
import com.tencent.mobileqq.wink.editor.util.WinkEditorLbsUtil;
import com.tencent.mobileqq.wink.editor.util.WinkUserInfoDataManager;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.tavcut.core.render.builder.light.model.Timeline;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.WatermarkDataSourceModel;
import com.tencent.videocut.model.WatermarkPoiModel;
import com.tencent.videocut.model.WatermarkPoiModelWrapper;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import org.light.TimeRange;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.FuncN;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001BB\t\b\u0002\u00a2\u0006\u0004\b@\u0010AJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0002Jp\u0010\u001c\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2:\u0010\u001d\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u0016H\u0002Jz\u0010#\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\n2:\u0010\u001d\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u0016H\u0002Jd\u0010$\u001a\u00020\u00062\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\n2:\u0010\u001d\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u0016H\u0002J\\\u0010+\u001a\u00020*2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010%\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u001f2(\u0010)\u001a$\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&\u0018\u00010(\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u00060\u0016J*\u00101\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u001f\u0012\u0004\u0012\u000200\u0018\u00010.2\u0006\u0010-\u001a\u00020,2\u0006\u0010\t\u001a\u00020\bJ\u001c\u00104\u001a\u00020\u00062\u0014\u0010)\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0004\u0012\u00020\u000602J\u0006\u00105\u001a\u00020\u0006R4\u0010:\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000406j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R4\u0010<\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000406j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0018\u0010?\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/WaterMarkDataManager;", "", "", "path", "Lcooperation/qzone/model/LocalImageShootInfo;", "v", "", "w", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavCutDelegate", "", "fromTemplateColl", "", "r", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "j", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermissionSupplier", "Lmqq/util/WeakReference;", "Landroidx/fragment/app/Fragment;", "hostFragmentRef", "Lkotlin/Function2;", "Lcooperation/qzone/LbsDataV2$PoiList;", "Lkotlin/ParameterName;", "name", "result", "", "t", "onResult", "qqPermission", "", "Lcooperation/qzone/model/GpsInfo4LocalImage;", "gpsInfos", "withLocation", HippyTKDListViewAdapter.X, ReportConstant.COSTREPORT_PREFIX, "hostFragment", "Lcom/tencent/videocut/model/WatermarkDataSourceModel;", "originModelList", "", "callback", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "l", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "Lkotlin/Pair;", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "", "i", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/wink/editor/model/c;", "u", tl.h.F, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "mediaExifCacheMap", "c", "pathStickerIdMap", "d", "Lcom/tencent/mobileqq/wink/editor/model/c;", "cacheUserInfo", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WaterMarkDataManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WaterMarkDataManager f321551a = new WaterMarkDataManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, LocalImageShootInfo> mediaExifCacheMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, LocalImageShootInfo> pathStickerIdMap = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WinkUserInfo cacheUserInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b#\u0010$J \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\t\u0010\b\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\"\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/WaterMarkDataManager$a;", "", "", "Lcom/tencent/videocut/model/WatermarkDataSourceModel;", "originModelList", "", "", "e", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getDate", "()J", "b", "(J)V", "date", "Lcooperation/qzone/LbsDataV2$PoiList;", "Lcooperation/qzone/LbsDataV2$PoiList;", "()Lcooperation/qzone/LbsDataV2$PoiList;", "c", "(Lcooperation/qzone/LbsDataV2$PoiList;)V", PoiListCacheRecord.POILIST, "Lcom/tencent/mobileqq/wink/editor/model/c;", "Lcom/tencent/mobileqq/wink/editor/model/c;", "getUserInfo", "()Lcom/tencent/mobileqq/wink/editor/model/c;", "d", "(Lcom/tencent/mobileqq/wink/editor/model/c;)V", ITVKPlayerEventListener.KEY_USER_INFO, "<init>", "(JLcooperation/qzone/LbsDataV2$PoiList;Lcom/tencent/mobileqq/wink/editor/model/c;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.WaterMarkDataManager$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class WaterMarkData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private long date;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private LbsDataV2.PoiList poiList;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private WinkUserInfo userInfo;

        public WaterMarkData() {
            this(0L, null, null, 7, null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final LbsDataV2.PoiList getPoiList() {
            return this.poiList;
        }

        public final void b(long j3) {
            this.date = j3;
        }

        public final void c(@Nullable LbsDataV2.PoiList poiList) {
            this.poiList = poiList;
        }

        public final void d(@Nullable WinkUserInfo winkUserInfo) {
            this.userInfo = winkUserInfo;
        }

        @NotNull
        public final Map<String, WatermarkDataSourceModel> e(@NotNull List<WatermarkDataSourceModel> originModelList) {
            boolean z16;
            int i3;
            Intrinsics.checkNotNullParameter(originModelList, "originModelList");
            HashMap hashMap = new HashMap();
            for (WatermarkDataSourceModel watermarkDataSourceModel : originModelList) {
                if (com.tencent.videocut.render.extension.i.e(watermarkDataSourceModel, false)) {
                    hashMap.put(watermarkDataSourceModel.dataKey, WatermarkDataSourceModel.copy$default(watermarkDataSourceModel, null, null, false, null, null, com.tencent.videocut.render.extension.i.n(this.date), null, null, 223, null));
                    z16 = false;
                } else {
                    z16 = false;
                }
                if (com.tencent.videocut.render.extension.i.b(watermarkDataSourceModel, z16)) {
                    String str = watermarkDataSourceModel.dataKey;
                    LbsDataV2.PoiList poiList = this.poiList;
                    if (poiList != null) {
                        i3 = com.tencent.mobileqq.wink.editor.util.l.b(poiList);
                    } else {
                        i3 = 0;
                    }
                    hashMap.put(str, WatermarkDataSourceModel.copy$default(watermarkDataSourceModel, null, null, false, null, null, null, com.tencent.videocut.render.extension.i.q(poiList, i3), null, 191, null));
                }
                if (com.tencent.videocut.render.extension.i.g(watermarkDataSourceModel, false)) {
                    hashMap.put(watermarkDataSourceModel.dataKey, WatermarkDataSourceModel.copy$default(watermarkDataSourceModel, null, null, false, null, com.tencent.videocut.render.extension.i.r(this.userInfo), null, null, null, 239, null));
                }
            }
            return hashMap;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WaterMarkData)) {
                return false;
            }
            WaterMarkData waterMarkData = (WaterMarkData) other;
            if (this.date == waterMarkData.date && Intrinsics.areEqual(this.poiList, waterMarkData.poiList) && Intrinsics.areEqual(this.userInfo, waterMarkData.userInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int a16 = androidx.fragment.app.a.a(this.date) * 31;
            LbsDataV2.PoiList poiList = this.poiList;
            int i3 = 0;
            if (poiList == null) {
                hashCode = 0;
            } else {
                hashCode = poiList.hashCode();
            }
            int i16 = (a16 + hashCode) * 31;
            WinkUserInfo winkUserInfo = this.userInfo;
            if (winkUserInfo != null) {
                i3 = winkUserInfo.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "WaterMarkData(date=" + this.date + ", poiList=" + this.poiList + ", userInfo=" + this.userInfo + ")";
        }

        public WaterMarkData(long j3, @Nullable LbsDataV2.PoiList poiList, @Nullable WinkUserInfo winkUserInfo) {
            this.date = j3;
            this.poiList = poiList;
            this.userInfo = winkUserInfo;
        }

        public /* synthetic */ WaterMarkData(long j3, LbsDataV2.PoiList poiList, WinkUserInfo winkUserInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? System.currentTimeMillis() : j3, (i3 & 2) != 0 ? null : poiList, (i3 & 4) != 0 ? null : winkUserInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/WaterMarkDataManager$b", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "", "cancel", "", "d", "Z", "a", "()Z", "canceled", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements com.tencent.mobileqq.wink.editor.subtitle.source.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean canceled;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Subscription f321559e;

        b(Subscription subscription) {
            this.f321559e = subscription;
            this.canceled = subscription.isUnsubscribed();
        }

        @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
        /* renamed from: a, reason: from getter */
        public boolean getCanceled() {
            return this.canceled;
        }

        @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
        public void cancel() {
            this.f321559e.unsubscribe();
        }
    }

    WaterMarkDataManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa A[LOOP:1: B:47:0x0085->B:57:0x00aa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ae A[EDGE_INSN: B:58:0x00ae->B:59:0x00ae BREAK  A[LOOP:1: B:47:0x0085->B:57:0x00aa], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String j(dr tavCutDelegate, long currentTime) {
        String str;
        boolean isBlank;
        boolean z16;
        ResourceModel resourceModel;
        String str2;
        boolean isBlank2;
        MediaModel mediaModel;
        List<MediaClip> list;
        Object orNull;
        boolean z17 = true;
        if (tavCutDelegate instanceof WinkImageTavCut) {
            WinkEditData h06 = tavCutDelegate.h0();
            if (h06 != null && (mediaModel = h06.getMediaModel()) != null && (list = mediaModel.videos) != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
                MediaClip mediaClip = (MediaClip) orNull;
                if (mediaClip != null) {
                    resourceModel = mediaClip.resource;
                    if (resourceModel == null) {
                        str2 = resourceModel.normalPath;
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                        if (!isBlank2) {
                            z17 = false;
                        }
                    }
                    if (!z17) {
                        if (resourceModel == null) {
                            return null;
                        }
                        return resourceModel.path;
                    }
                    if (resourceModel == null) {
                        return null;
                    }
                    return resourceModel.normalPath;
                }
            }
            resourceModel = null;
            if (resourceModel == null) {
            }
            if (str2 != null) {
            }
            if (!z17) {
            }
        } else {
            if (!(tavCutDelegate instanceof WinkVideoTavCut)) {
                return null;
            }
            List<Timeline> F1 = ((WinkVideoTavCut) tavCutDelegate).F1();
            ArrayList arrayList = new ArrayList();
            for (Object obj : F1) {
                if (Intrinsics.areEqual(((Timeline) obj).getType(), "VideoSource")) {
                    arrayList.add(obj);
                }
            }
            if (currentTime == -1) {
                currentTime = tavCutDelegate.getCurrentPlayUs();
            }
            Iterator it = arrayList.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    TimeRange range = ((Timeline) it.next()).getRange();
                    if (range != null) {
                        long j3 = range.startTime;
                        if (j3 <= currentTime && j3 + range.duration > currentTime) {
                            z16 = true;
                            if (!z16) {
                                break;
                            }
                            i3++;
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 < 0 || i3 >= tavCutDelegate.g0().size()) {
                return null;
            }
            ResourceModel resourceModel2 = tavCutDelegate.g0().get(i3).resource;
            if (resourceModel2 != null) {
                str = resourceModel2.normalPath;
            } else {
                str = null;
            }
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z17 = false;
                }
            }
            if (z17) {
                if (resourceModel2 == null) {
                    return null;
                }
                return resourceModel2.path;
            }
            if (resourceModel2 == null) {
                return null;
            }
            return resourceModel2.normalPath;
        }
    }

    static /* synthetic */ String k(WaterMarkDataManager waterMarkDataManager, dr drVar, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = -1;
        }
        return waterMarkDataManager.j(drVar, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function2 callback, Throwable th5) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(null, th5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function0 qqPermissionSupplier, WeakReference hostFragmentRef, dr tavCutDelegate, boolean z16, final String type, final Subscriber subscriber) {
        Intrinsics.checkNotNullParameter(qqPermissionSupplier, "$qqPermissionSupplier");
        Intrinsics.checkNotNullParameter(hostFragmentRef, "$hostFragmentRef");
        Intrinsics.checkNotNullParameter(tavCutDelegate, "$tavCutDelegate");
        Intrinsics.checkNotNullParameter(type, "$type");
        f321551a.t(qqPermissionSupplier, hostFragmentRef, tavCutDelegate, z16, new Function2<LbsDataV2.PoiList, Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.WaterMarkDataManager$getDataByCurrentClip$subs$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LbsDataV2.PoiList poiList, Throwable th5) {
                invoke2(poiList, th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable LbsDataV2.PoiList poiList, @Nullable Throwable th5) {
                if (th5 != null) {
                    subscriber.onError(th5);
                } else if (poiList == null) {
                    subscriber.onError(new IllegalArgumentException("empty poi result"));
                } else {
                    subscriber.onNext(TuplesKt.to(type, poiList));
                    subscriber.onCompleted();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final String type, final Subscriber subscriber) {
        Intrinsics.checkNotNullParameter(type, "$type");
        f321551a.u(new Function1<WinkUserInfo, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.WaterMarkDataManager$getDataByCurrentClip$subs$1$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkUserInfo winkUserInfo) {
                invoke2(winkUserInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable WinkUserInfo winkUserInfo) {
                if (winkUserInfo == null) {
                    subscriber.onError(new IllegalArgumentException("empty userinfo result"));
                } else {
                    subscriber.onNext(TuplesKt.to(type, winkUserInfo));
                    subscriber.onCompleted();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WaterMarkData p(Object[] it) {
        String str;
        WaterMarkData waterMarkData = new WaterMarkData(0L, null, null, 7, null);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        for (Object obj : it) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Pair<kotlin.String, kotlin.Any>");
            Pair pair = (Pair) obj;
            String str2 = (String) pair.component1();
            Object component2 = pair.component2();
            int hashCode = str2.hashCode();
            if (hashCode != -1647206594) {
                if (hashCode != -1532486729) {
                    if (hashCode == 480866946 && str2.equals(LightConstants.DataSourceKey.USER_INFO)) {
                        Intrinsics.checkNotNull(component2, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.model.WinkUserInfo");
                        waterMarkData.d((WinkUserInfo) component2);
                    }
                } else if (str2.equals(LightConstants.DataSourceKey.DATE)) {
                    Intrinsics.checkNotNull(component2, "null cannot be cast to non-null type kotlin.Long");
                    waterMarkData.b(((Long) component2).longValue());
                }
            } else if (str2.equals(LightConstants.DataSourceKey.LOCATION)) {
                Intrinsics.checkNotNull(component2, "null cannot be cast to non-null type cooperation.qzone.LbsDataV2.PoiList");
                waterMarkData.c((LbsDataV2.PoiList) component2);
                LbsDataV2.PoiList poiList = waterMarkData.getPoiList();
                Intrinsics.checkNotNull(poiList);
                LbsDataV2.PoiInfo a16 = com.tencent.mobileqq.wink.editor.util.l.a(poiList);
                if (a16 != null) {
                    str = a16.poiId;
                } else {
                    str = null;
                }
                if (str != null) {
                    a16.poiId = "MEDIA_ORIGIN_POI_PREFIX_" + a16.poiId;
                }
            }
        }
        return waterMarkData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final long r(dr tavCutDelegate, boolean fromTemplateColl) {
        Long l3;
        long currentTimeMillis;
        long currentTimeMillis2;
        if (fromTemplateColl) {
            currentTimeMillis2 = System.currentTimeMillis();
        } else {
            String k3 = k(this, tavCutDelegate, 0L, 2, null);
            if (k3 == null) {
                currentTimeMillis2 = System.currentTimeMillis();
            } else {
                LocalImageShootInfo localImageShootInfo = mediaExifCacheMap.get(k3);
                if (localImageShootInfo == null) {
                    localImageShootInfo = v(k3);
                }
                if (localImageShootInfo != null) {
                    l3 = Long.valueOf(localImageShootInfo.captureTime);
                } else {
                    l3 = null;
                }
                if (l3 != null && l3.longValue() > 0) {
                    currentTimeMillis = l3.longValue();
                } else {
                    currentTimeMillis = System.currentTimeMillis();
                }
                return currentTimeMillis * 1000;
            }
        }
        return currentTimeMillis2 * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(final List<? extends GpsInfo4LocalImage> gpsInfos, final String path, boolean withLocation, final Function2<? super LbsDataV2.PoiList, ? super Throwable, Unit> onResult) {
        if (!NetworkUtil.isNetSupport(com.tencent.mobileqq.wink.b.c())) {
            onResult.invoke(null, new IllegalStateException("network offline"));
        } else {
            WinkEditorLbsUtil.f322604d.e(gpsInfos, withLocation, new Function2<LbsDataV2.PoiList, Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.WaterMarkDataManager$getPoi$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LbsDataV2.PoiList poiList, Throwable th5) {
                    invoke2(poiList, th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable LbsDataV2.PoiList poiList, @Nullable Throwable th5) {
                    List<GpsInfo4LocalImage> list = gpsInfos;
                    ArrayList<LbsDataV2.PoiInfo> arrayList = poiList != null ? poiList.poiInfos : null;
                    w53.b.a("wink_sticker_TextMetaMaterial", "getPoi: " + list + " " + poiList + " " + arrayList + " " + th5 + " " + path);
                    onResult.invoke(poiList, th5);
                }
            });
        }
    }

    private final void t(Function0<? extends QQPermission> qqPermissionSupplier, WeakReference<Fragment> hostFragmentRef, dr tavCutDelegate, boolean fromTemplateColl, Function2<? super LbsDataV2.PoiList, ? super Throwable, Unit> onResult) {
        List<? extends GpsInfo4LocalImage> listOf;
        if (fromTemplateColl) {
            x(qqPermissionSupplier.invoke(), hostFragmentRef, null, "", true, onResult);
            return;
        }
        String k3 = k(this, tavCutDelegate, 0L, 2, null);
        GpsInfo4LocalImage gpsInfo4LocalImage = null;
        if (k3 == null) {
            onResult.invoke(null, new IllegalArgumentException("current playing clips is null"));
            return;
        }
        LocalImageShootInfo localImageShootInfo = mediaExifCacheMap.get(k3);
        if (localImageShootInfo == null) {
            localImageShootInfo = v(k3);
        }
        if (localImageShootInfo != null) {
            gpsInfo4LocalImage = localImageShootInfo.gpsInfo;
        }
        if (gpsInfo4LocalImage != null) {
            QQPermission invoke = qqPermissionSupplier.invoke();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(gpsInfo4LocalImage);
            x(invoke, hostFragmentRef, listOf, k3, false, onResult);
            return;
        }
        x(qqPermissionSupplier.invoke(), hostFragmentRef, null, k3, true, onResult);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final LocalImageShootInfo v(String path) {
        LocalImageShootInfo createFromForVideo;
        HashMap<String, LocalImageShootInfo> hashMap = mediaExifCacheMap;
        LocalImageShootInfo localImageShootInfo = hashMap.get(path);
        if (localImageShootInfo != null) {
            return localImageShootInfo;
        }
        LocalImageShootInfo localImageShootInfo2 = null;
        if (QAlbumUtil.getMediaType(path) == 0) {
            createFromForVideo = LocalImageShootInfo.createFrom(path, false);
            if (createFromForVideo != null) {
                createFromForVideo.path = path;
                f321551a.w(createFromForVideo);
                localImageShootInfo2 = createFromForVideo;
            }
            if (localImageShootInfo2 != null) {
                hashMap.put(path, localImageShootInfo2);
            }
            return localImageShootInfo2;
        }
        if (QAlbumUtil.getMediaType(path) == 1 && (createFromForVideo = LocalImageShootInfo.createFromForVideo(path, false)) != null) {
            createFromForVideo.path = path;
            f321551a.w(createFromForVideo);
            localImageShootInfo2 = createFromForVideo;
        }
        if (localImageShootInfo2 != null) {
        }
        return localImageShootInfo2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0011 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void w(LocalImageShootInfo localImageShootInfo) {
        boolean z16;
        boolean isBlank;
        String str = localImageShootInfo.captureTimeString;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    try {
                        localImageShootInfo.captureTime = ISO8601Utils.parse(localImageShootInfo.captureTimeString, new ParsePosition(0)).getTime();
                        return;
                    } catch (Exception e16) {
                        w53.b.d("wink_sticker_TextMetaMaterial", "ISO8601Utils parse fail: ", e16);
                        return;
                    }
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    private final void x(final QQPermission qqPermission, final WeakReference<Fragment> hostFragmentRef, final List<? extends GpsInfo4LocalImage> gpsInfos, final String path, final boolean withLocation, final Function2<? super LbsDataV2.PoiList, ? super Throwable, Unit> onResult) {
        com.tencent.videocut.utils.thread.c.f384289c.e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.t
            @Override // java.lang.Runnable
            public final void run() {
                WaterMarkDataManager.y(withLocation, gpsInfos, path, onResult, hostFragmentRef, qqPermission);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void y(final boolean z16, final List list, final String path, final Function2 onResult, WeakReference hostFragmentRef, QQPermission qqPermission) {
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(onResult, "$onResult");
        Intrinsics.checkNotNullParameter(hostFragmentRef, "$hostFragmentRef");
        Intrinsics.checkNotNullParameter(qqPermission, "$qqPermission");
        if (!z16) {
            f321551a.s(list, path, false, onResult);
            return;
        }
        Fragment fragment = (Fragment) hostFragmentRef.get();
        if (fragment != null) {
            WinkEditorLbsUtil.f322604d.l(qqPermission, fragment, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.WaterMarkDataManager$requestPoi$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WaterMarkDataManager.f321551a.s(list, path, z16, onResult);
                }
            }, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.WaterMarkDataManager$requestPoi$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    onResult.invoke(null, new IllegalArgumentException("permission deny"));
                }
            });
        } else {
            onResult.invoke(null, new IllegalArgumentException("hostFragment null"));
        }
    }

    public final void h() {
        cacheUserInfo = null;
    }

    @Nullable
    public final Pair<List<LbsDataV2.PoiInfo>, Integer> i(@NotNull WinkStickerModel stickerModel, @NotNull dr tavCutDelegate) {
        WatermarkPoiModelWrapper watermarkPoiModelWrapper;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        Intrinsics.checkNotNullParameter(tavCutDelegate, "tavCutDelegate");
        WatermarkDataSourceModel watermarkDataSourceModel = stickerModel.watermarkModel.get(LightConstants.DataSourceKey.LOCATION);
        if (watermarkDataSourceModel != null) {
            watermarkPoiModelWrapper = watermarkDataSourceModel.watermarkPoiModelWrapper;
        } else {
            watermarkPoiModelWrapper = null;
        }
        if (watermarkPoiModelWrapper == null || !(!watermarkPoiModelWrapper.poiModelList.isEmpty()) || watermarkPoiModelWrapper.usedPoiModel == null) {
            return null;
        }
        List<WatermarkPoiModel> list = watermarkPoiModelWrapper.poiModelList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.tencent.videocut.render.extension.i.i((WatermarkPoiModel) it.next()));
        }
        Iterator<WatermarkPoiModel> it5 = watermarkPoiModelWrapper.poiModelList.iterator();
        int i3 = 0;
        while (true) {
            if (it5.hasNext()) {
                if (Intrinsics.areEqual(it5.next().poiId, watermarkPoiModelWrapper.usedPoiModel.poiId)) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        return TuplesKt.to(arrayList, Integer.valueOf(Math.max(0, i3)));
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.subtitle.source.a l(@NotNull final Function0<? extends QQPermission> qqPermissionSupplier, @NotNull Fragment hostFragment, @NotNull final dr tavCutDelegate, @NotNull final List<WatermarkDataSourceModel> originModelList, @NotNull final Function2<? super Map<String, WatermarkDataSourceModel>, ? super Throwable, Unit> callback) {
        WinkEditorFragment winkEditorFragment;
        int collectionSizeOrDefault;
        Observable create;
        WinkEditorViewModel Tk;
        Intrinsics.checkNotNullParameter(qqPermissionSupplier, "qqPermissionSupplier");
        Intrinsics.checkNotNullParameter(hostFragment, "hostFragment");
        Intrinsics.checkNotNullParameter(tavCutDelegate, "tavCutDelegate");
        Intrinsics.checkNotNullParameter(originModelList, "originModelList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (hostFragment instanceof WinkEditorFragment) {
            winkEditorFragment = (WinkEditorFragment) hostFragment;
        } else {
            winkEditorFragment = null;
        }
        boolean z16 = false;
        if (winkEditorFragment != null && (Tk = winkEditorFragment.Tk()) != null && Tk.getIsFromTemplateColl()) {
            z16 = true;
        }
        final WeakReference weakReference = new WeakReference(hostFragment);
        List<WatermarkDataSourceModel> list = originModelList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            final String str = ((WatermarkDataSourceModel) it.next()).dataKey;
            int hashCode = str.hashCode();
            if (hashCode != -1647206594) {
                if (hashCode != -1532486729) {
                    if (hashCode == 480866946 && str.equals(LightConstants.DataSourceKey.USER_INFO)) {
                        create = Observable.create(new Observable.OnSubscribe() { // from class: com.tencent.mobileqq.wink.editor.sticker.p
                            @Override // rx.functions.Action1
                            public final void call(Object obj) {
                                WaterMarkDataManager.o(str, (Subscriber) obj);
                            }
                        });
                        arrayList.add(create);
                    }
                    throw new IllegalArgumentException("unknown data type " + str);
                }
                if (str.equals(LightConstants.DataSourceKey.DATE)) {
                    create = Observable.just(TuplesKt.to(str, Long.valueOf(f321551a.r(tavCutDelegate, z16))));
                    arrayList.add(create);
                } else {
                    throw new IllegalArgumentException("unknown data type " + str);
                }
            } else if (str.equals(LightConstants.DataSourceKey.LOCATION)) {
                final boolean z17 = z16;
                create = Observable.create(new Observable.OnSubscribe() { // from class: com.tencent.mobileqq.wink.editor.sticker.o
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        WaterMarkDataManager.n(Function0.this, weakReference, tavCutDelegate, z17, str, (Subscriber) obj);
                    }
                });
                arrayList.add(create);
            } else {
                throw new IllegalArgumentException("unknown data type " + str);
            }
        }
        Observable observeOn = Observable.zip(arrayList, new FuncN() { // from class: com.tencent.mobileqq.wink.editor.sticker.q
            @Override // rx.functions.FuncN
            public final Object call(Object[] objArr) {
                WaterMarkDataManager.WaterMarkData p16;
                p16 = WaterMarkDataManager.p(objArr);
                return p16;
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<WaterMarkData, Unit> function1 = new Function1<WaterMarkData, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.WaterMarkDataManager$getDataByCurrentClip$subs$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WaterMarkDataManager.WaterMarkData waterMarkData) {
                invoke2(waterMarkData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WaterMarkDataManager.WaterMarkData waterMarkData) {
                callback.invoke(waterMarkData.e(originModelList), null);
            }
        };
        return new b(observeOn.subscribe(new Action1() { // from class: com.tencent.mobileqq.wink.editor.sticker.r
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                WaterMarkDataManager.q(Function1.this, obj);
            }
        }, new Action1() { // from class: com.tencent.mobileqq.wink.editor.sticker.s
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                WaterMarkDataManager.m(Function2.this, (Throwable) obj);
            }
        }));
    }

    public final void u(@NotNull Function1<? super WinkUserInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        WinkUserInfo winkUserInfo = cacheUserInfo;
        if (winkUserInfo != null) {
            callback.invoke(winkUserInfo);
        } else if (!NetworkUtil.isNetSupport(com.tencent.mobileqq.wink.b.c())) {
            callback.invoke(null);
        } else {
            WinkUserInfoDataManager.INSTANCE.b().e(callback);
        }
    }
}
