package com.qzone.reborn.albumx.qzonex.part.upload;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.ui.widget.g;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.api.IVasYellowDiamondPay;
import com.tencent.mobileqq.vas.troop.e;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 b2\u00020\u0001:\u0002cdB\u000f\u0012\u0006\u0010:\u001a\u00020\u0006\u00a2\u0006\u0004\ba\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0002J0\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0014j\b\u0012\u0004\u0012\u00020\u0006`\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0014j\b\u0012\u0004\u0012\u00020\u0006`\u0015H\u0002J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J \u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010!\u001a\u00020\u000fH\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\u000fH\u0002J\b\u0010&\u001a\u00020\u0006H\u0016J\u0012\u0010'\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020,0+J\"\u00101\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u00103\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u00010\u0018H\u0016R\"\u0010:\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010=\u001a\n ;*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00105R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0018\u0010F\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR#\u0010R\u001a\n ;*\u0004\u0018\u00010M0M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR#\u0010W\u001a\n ;*\u0004\u0018\u00010S0S8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010O\u001a\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010]\u00a8\u0006e"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/upload/QZAlbumxUploadQualitySelectBarPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Z9", "", "aid", "ia", "R9", LocaleUtils.L_JAPANESE, "elementId", "view", "P9", "Lcom/tencent/util/Pair;", "", "ca", "O9", "X9", "U9", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mediaList", "T9", "Landroid/content/Intent;", "data", "da", "na", "isImageSelected", "isVideoSelected", "needShow", "la", "ma", "ba", "Y9", "isGray", "Q9", "N9", "getLogTag", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "", "", "W9", "", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "newIntent", "onNewIntent", "d", "Ljava/lang/String;", "getDaTongPageId", "()Ljava/lang/String;", "setDaTongPageId", "(Ljava/lang/String;)V", "daTongPageId", "kotlin.jvm.PlatformType", "e", "haveToChoose", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "qualityBarLayout", tl.h.F, "openYellowTipsContainer", "i", "Landroid/view/View;", "yellowDiamondTipsContainerOriginalGv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "albumDivider", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "imageIcon", "Lqc/b;", "D", "Lkotlin/Lazy;", "V9", "()Lqc/b;", "uploadVm", "Ltl/h;", "E", "S9", "()Ltl/h;", "mediaPickerVm", "Lcom/qzone/album/ui/widget/g;", UserInfo.SEX_FEMALE, "Lcom/qzone/album/ui/widget/g;", "photoSizeView", "G", "Z", "isGrayUser", "H", "isRealVip", "<init>", "I", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxUploadQualitySelectBarPart extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView imageIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy uploadVm;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy mediaPickerVm;

    /* renamed from: F, reason: from kotlin metadata */
    private com.qzone.album.ui.widget.g photoSizeView;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isGrayUser;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isRealVip;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String daTongPageId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String haveToChoose;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout qualityBarLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout openYellowTipsContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View yellowDiamondTipsContainerOriginalGv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View albumDivider;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/upload/QZAlbumxUploadQualitySelectBarPart$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "Lmqq/util/WeakReference;", "Lcom/qzone/reborn/albumx/qzonex/part/upload/QZAlbumxUploadQualitySelectBarPart;", "a", "Lmqq/util/WeakReference;", "mWeakReference", "b", "Ljava/lang/String;", "tag", "part", "<init>", "(Lcom/qzone/reborn/albumx/qzonex/part/upload/QZAlbumxUploadQualitySelectBarPart;Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QZAlbumxUploadQualitySelectBarPart> mWeakReference;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String tag;

        public b(QZAlbumxUploadQualitySelectBarPart part, String tag) {
            Intrinsics.checkNotNullParameter(part, "part");
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.mWeakReference = new WeakReference<>(part);
            this.tag = tag;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            WeakReference<QZAlbumxUploadQualitySelectBarPart> weakReference = this.mWeakReference;
            if (weakReference == null) {
                return new LinkedHashMap();
            }
            QZAlbumxUploadQualitySelectBarPart qZAlbumxUploadQualitySelectBarPart = weakReference.get();
            if (qZAlbumxUploadQualitySelectBarPart == null) {
                return new LinkedHashMap();
            }
            if (Intrinsics.areEqual(this.tag, "yellow_tips")) {
                return qZAlbumxUploadQualitySelectBarPart.W9();
            }
            return new HashMap();
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/upload/QZAlbumxUploadQualitySelectBarPart$c", "Lcom/tencent/mobileqq/vas/api/IVasYellowDiamondPay$a;", "", "isSuccess", "", "code", "", "msg", "", "onResult", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements IVasYellowDiamondPay.a {
        c() {
        }

        @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay.a
        public void onResult(boolean isSuccess, int code, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            VipNtMMKV.INSTANCE.getCommon(LoginData.getInstance().getUinString()).encodeBool("qzone_request_real_vip", false);
            if (isSuccess) {
                QZAlbumxUploadQualitySelectBarPart.this.ja();
            }
        }
    }

    public QZAlbumxUploadQualitySelectBarPart(String daTongPageId) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(daTongPageId, "daTongPageId");
        this.daTongPageId = daTongPageId;
        this.haveToChoose = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastHaveToChoosePhotoOrVideo", "\u672a\u9009\u62e9\u7167\u7247\u6216\u89c6\u9891");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<qc.b>() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadQualitySelectBarPart$uploadVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final qc.b invoke() {
                return (qc.b) QZAlbumxUploadQualitySelectBarPart.this.getViewModel(qc.b.class);
            }
        });
        this.uploadVm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<tl.h>() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadQualitySelectBarPart$mediaPickerVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final tl.h invoke() {
                return (tl.h) QZAlbumxUploadQualitySelectBarPart.this.getViewModel(tl.h.class);
            }
        });
        this.mediaPickerVm = lazy2;
    }

    private final boolean N9() {
        return LoginData.getInstance().isQzoneVip() || this.isRealVip;
    }

    private final void O9() {
        V9().k2(getActivity().getIntent().getIntExtra(QZoneHelper.QZoneAlbumConstants.KEY_QUALITY, -2016082619));
        if (V9().getCurrentImageUploadQuality() == -2016082619) {
            V9().k2(v5.a.a().d("photo"));
            V9().l2(v5.a.a().d("video"));
            if (V9().getCurrentImageUploadQuality() == -2016082619) {
                V9().k2(0);
                u5.b.L0("photo", V9().getCurrentImageUploadQuality(), LoginData.getInstance().getUin());
            }
        }
        if (LoginData.getInstance().isQzoneVip() || V9().getCurrentVideoUploadQuality() != 3) {
            return;
        }
        V9().l2(0);
        u5.b.L0("video", V9().getCurrentVideoUploadQuality(), LoginData.getInstance().getUin());
    }

    private final void P9(String elementId, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_eid", elementId);
        hashMap.put("qq_pgid", this.daTongPageId);
        fo.c.q(view, elementId, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(boolean isGray) {
        this.isGrayUser = isGray;
        if (isGray) {
            if (!VipNtMMKV.INSTANCE.getCommon(LoginData.getInstance().getUinString()).decodeBool("vas_uplod_photo_key", true) && N9()) {
                V9().k2(v5.a.a().d("photo"));
                V9().l2(v5.a.a().d("video"));
                if (V9().getCurrentImageUploadQuality() == -2016082619) {
                    V9().k2(0);
                    u5.b.L0("photo", V9().getCurrentImageUploadQuality(), LoginData.getInstance().getUin());
                }
            } else {
                V9().k2(2);
            }
            na();
            View view = this.yellowDiamondTipsContainerOriginalGv;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    private final void R9(View rootView) {
        fo.b h16 = new fo.b().l(new HashMap()).g(ClickPolicy.REPORT_NONE).h(new b(this, "yellow_tips"));
        fo.c.l(this.openYellowTipsContainer, rootView);
        fo.c.o(this.openYellowTipsContainer, "em_qz_notice_strip", h16);
    }

    private final tl.h S9() {
        return (tl.h) this.mediaPickerVm.getValue();
    }

    private final ArrayList<String> T9(ArrayList<String> mediaList) {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = mediaList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!S9().R1().containsKey(mediaList.get(i3))) {
                arrayList.add(mediaList.get(i3));
            }
        }
        return arrayList;
    }

    private final String U9() {
        DynamicArrayList<String> value;
        HashMap<String, LocalMediaInfo> Q1 = S9().Q1();
        if (Q1 == null || (value = S9().P1().getValue()) == null) {
            return null;
        }
        int size = value.size();
        for (int i3 = 0; i3 < size; i3++) {
            LocalMediaInfo localMediaInfo = Q1.get(value.get(i3));
            if (localMediaInfo != null && !TextUtils.isEmpty(localMediaInfo.missionID)) {
                return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_QUALITY_TEXT_DIFF, com.qzone.util.l.a(R.string.f2199567t));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final qc.b V9() {
        return (qc.b) this.uploadVm.getValue();
    }

    private final void X9() {
        boolean W1 = S9().W1();
        boolean X1 = S9().X1();
        if (!W1 && !X1) {
            com.qzone.reborn.util.o.f59556a.d(this.haveToChoose, 1);
            return;
        }
        Intent l3 = ak.l(getActivity(), "com.qzone.publish.ui.activity.QZoneUploadQualityActivity");
        DynamicArrayList<String> value = S9().P1().getValue();
        l3.putStringArrayListExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_SELECTED_ARRAY", value != null ? T9(value) : null);
        if (W1) {
            l3.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_QUALITY", V9().getCurrentImageUploadQuality());
        } else {
            l3.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_QUALITY", -2016082619);
        }
        if (X1) {
            l3.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_VIDEO_QUALITY", V9().getCurrentVideoUploadQuality());
        } else {
            l3.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_VIDEO_QUALITY", -2016082619);
        }
        l3.putExtra("INTENT_QUALITY_DIFF_TEXT", U9());
        l3.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_IS_GRAY_USER", this.isGrayUser);
        getActivity().startActivityForResult(l3, 607);
    }

    private final void Y9() {
        na.e eVar = na.e.f419543a;
        eVar.c(LoginData.getInstance().getUin(), new QZAlbumxUploadQualitySelectBarPart$initVasData$1(this));
        if (N9()) {
            eVar.b(4, new Function1<e.DialogData, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadQualitySelectBarPart$initVasData$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(e.DialogData dialogData) {
                    invoke2(dialogData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(e.DialogData dialogData) {
                    com.tencent.mobileqq.vas.troop.e.INSTANCE.b(dialogData);
                }
            });
        }
    }

    private final void Z9(View rootView) {
        if (N9()) {
            return;
        }
        View inflate = ((ViewStub) rootView.findViewById(R.id.f69983k8)).inflate();
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.openYellowTipsContainer = (RelativeLayout) inflate;
        if (QQTheme.isNowThemeIsNight()) {
            RelativeLayout relativeLayout = this.openYellowTipsContainer;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundResource(R.drawable.obs);
            }
        } else {
            RelativeLayout relativeLayout2 = this.openYellowTipsContainer;
            if (relativeLayout2 != null) {
                relativeLayout2.setBackgroundResource(R.drawable.obr);
            }
        }
        RelativeLayout relativeLayout3 = this.openYellowTipsContainer;
        if (relativeLayout3 != null) {
            relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxUploadQualitySelectBarPart.aa(QZAlbumxUploadQualitySelectBarPart.this, view);
                }
            });
        }
        R9(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0035, code lost:
    
        if (r1.booleanValue() != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void aa(QZAlbumxUploadQualitySelectBarPart this$0, View v3) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        Pair<Boolean, Boolean> ca5 = this$0.ca();
        Boolean bool = ca5.first;
        Intrinsics.checkNotNullExpressionValue(bool, "isSelect.first");
        if (!bool.booleanValue()) {
            Boolean bool2 = ca5.second;
            Intrinsics.checkNotNullExpressionValue(bool2, "isSelect.second");
        }
        Boolean bool3 = ca5.first;
        Intrinsics.checkNotNullExpressionValue(bool3, "isSelect.first");
        if (bool3.booleanValue()) {
            Boolean bool4 = ca5.second;
            Intrinsics.checkNotNullExpressionValue(bool4, "isSelect.second");
            if (bool4.booleanValue()) {
                str = "jhan.hz.rk.tq_ytyspsc";
                this$0.P9("em_qz_notice_strip", v3);
                this$0.ia(str);
                EventCollector.getInstance().onViewClicked(v3);
            }
        }
        Boolean bool5 = ca5.first;
        Intrinsics.checkNotNullExpressionValue(bool5, "isSelect.first");
        if (bool5.booleanValue()) {
            str = "jhan.hz.rk.tq_ytsc";
        } else {
            str = "jhan.hz.rk.tq_yspsc";
        }
        this$0.P9("em_qz_notice_strip", v3);
        this$0.ia(str);
        EventCollector.getInstance().onViewClicked(v3);
    }

    private final boolean ba() {
        return (this.isGrayUser || (LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, LoginData.getInstance().getUin()) & 8388608) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Boolean, Boolean> ca() {
        return new Pair<>(Boolean.valueOf(S9().W1()), Boolean.valueOf(S9().X1()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(QZAlbumxUploadQualitySelectBarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(QZAlbumxUploadQualitySelectBarPart this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V9().c2().setValue(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ia(String aid) {
        VipNtMMKV.INSTANCE.getCommon(LoginData.getInstance().getUinString()).encodeBool("qzone_request_real_vip", true);
        ((IVasYellowDiamondPay) QRoute.api(IVasYellowDiamondPay.class)).openPayWithSchema(com.tencent.mobileqq.vas.troop.f.f311020a.a(aid), new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ja() {
        na.e.f419543a.e(new QZAlbumxUploadQualitySelectBarPart$requestRealVip$1(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
    
        if ((r3 != null ? r3.size() : 0) > 0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void la(boolean isImageSelected, boolean isVideoSelected, boolean needShow) {
        RelativeLayout relativeLayout;
        int i3;
        if (!this.isGrayUser || (relativeLayout = this.openYellowTipsContainer) == null) {
            return;
        }
        Intrinsics.checkNotNull(relativeLayout);
        View findViewById = relativeLayout.findViewById(R.id.f116446yr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "openYellowTipsContainer!\u2026d(R.id.vas_pay_tips_text)");
        TextView textView = (TextView) findViewById;
        if (isImageSelected) {
            textView.setText(com.tencent.mobileqq.vas.troop.f.f311020a.b());
        } else if (isVideoSelected) {
            textView.setText(com.tencent.mobileqq.vas.troop.f.f311020a.d());
        }
        DynamicArrayList<String> value = S9().P1().getValue();
        RelativeLayout relativeLayout2 = this.openYellowTipsContainer;
        Intrinsics.checkNotNull(relativeLayout2);
        if (!N9() && needShow) {
            i3 = 0;
        }
        i3 = 8;
        relativeLayout2.setVisibility(i3);
    }

    private final void ma(boolean isVideoSelected, boolean isImageSelected) {
        RelativeLayout relativeLayout = this.qualityBarLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qualityBarLayout");
            relativeLayout = null;
        }
        TextView textView = (TextView) relativeLayout.findViewById(R.id.fpr);
        if (textView != null) {
            if (isVideoSelected) {
                if (!N9() || V9().getCurrentVideoUploadQuality() == 3) {
                    textView.setText(R.string.f173047gp1);
                    return;
                } else if (!isImageSelected) {
                    textView.setText("\u753b\u8d28\uff08\u53ef\u9009\u539f\u753b\u4e0a\u4f20\uff09");
                    return;
                } else {
                    textView.setText("\u753b\u8d28\uff08\u53ef\u9009\u539f\u56fe\u4e0a\u4f20\uff09");
                    return;
                }
            }
            if (this.isGrayUser) {
                if (N9() && V9().getCurrentImageUploadQuality() != 3) {
                    textView.setText("\u753b\u8d28\uff08\u53ef\u9009\u539f\u56fe\u4e0a\u4f20\uff09");
                    return;
                } else {
                    textView.setText(R.string.f173047gp1);
                    return;
                }
            }
            textView.setText(R.string.f173047gp1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void na() {
        if (this.photoSizeView == null) {
            return;
        }
        boolean W1 = S9().W1();
        boolean X1 = S9().X1();
        ma(X1, W1);
        com.qzone.album.ui.widget.g gVar = this.photoSizeView;
        Intrinsics.checkNotNull(gVar);
        gVar.g(this.isGrayUser);
        boolean isEmpty = TextUtils.isEmpty(V9().a2().getPhotoRepairTaskId());
        com.qzone.album.ui.widget.g gVar2 = this.photoSizeView;
        Intrinsics.checkNotNull(gVar2);
        gVar2.f(isEmpty);
        la(W1, X1, isEmpty);
        if (!W1 && X1) {
            com.qzone.album.ui.widget.g gVar3 = this.photoSizeView;
            Intrinsics.checkNotNull(gVar3);
            gVar3.i(S9().P1().getValue(), V9().getCurrentVideoUploadQuality(), 1);
        } else {
            if (V9().getCurrentImageUploadQuality() == 3 && ba()) {
                V9().k2(0);
            }
            com.qzone.album.ui.widget.g gVar4 = this.photoSizeView;
            Intrinsics.checkNotNull(gVar4);
            gVar4.h(S9().P1().getValue(), V9().getCurrentImageUploadQuality());
        }
    }

    public final Map<String, Object> W9() {
        int i3;
        HashMap hashMap = new HashMap();
        Pair<Boolean, Boolean> ca5 = ca();
        Boolean bool = ca5.first;
        Intrinsics.checkNotNullExpressionValue(bool, "isSelect.first");
        if (bool.booleanValue()) {
            Boolean bool2 = ca5.second;
            Intrinsics.checkNotNullExpressionValue(bool2, "isSelect.second");
            if (bool2.booleanValue()) {
                i3 = 0;
                hashMap.put("strip_type", Integer.valueOf(i3));
                return hashMap;
            }
        }
        Boolean bool3 = ca5.second;
        Intrinsics.checkNotNullExpressionValue(bool3, "isSelect.second");
        i3 = bool3.booleanValue() ? 2 : 1;
        hashMap.put("strip_type", Integer.valueOf(i3));
        return hashMap;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QZAlbumxUploadQualitySelectBarPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 607) {
            da(data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            this.yellowDiamondTipsContainerOriginalGv = rootView.findViewById(R.id.x5d);
            View inflate = ((ViewStub) rootView.findViewById(R.id.vt5)).inflate();
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
            RelativeLayout relativeLayout = (RelativeLayout) inflate;
            this.qualityBarLayout = relativeLayout;
            RelativeLayout relativeLayout2 = null;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qualityBarLayout");
                relativeLayout = null;
            }
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxUploadQualitySelectBarPart.ea(QZAlbumxUploadQualitySelectBarPart.this, view);
                }
            });
            View findViewById = rootView.findViewById(R.id.f68673go);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_image_icon)");
            this.imageIcon = (ImageView) findViewById;
            com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
            ImageView imageView = this.imageIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
                imageView = null;
            }
            a16.j(imageView, new c.C8489c().h("qui_image").e(R.color.qui_common_icon_primary));
            O9();
            View findViewById2 = rootView.findViewById(R.id.f164258p8);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.album_divider)");
            this.albumDivider = findViewById2;
            RelativeLayout relativeLayout3 = this.qualityBarLayout;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qualityBarLayout");
                relativeLayout3 = null;
            }
            View view = this.albumDivider;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumDivider");
                view = null;
            }
            com.qzone.album.ui.widget.g gVar = new com.qzone.album.ui.widget.g(relativeLayout3, view, V9().getCurrentImageUploadQuality());
            this.photoSizeView = gVar;
            Intrinsics.checkNotNull(gVar);
            gVar.e(new g.a() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.h
                @Override // com.qzone.album.ui.widget.g.a
                public final void a(boolean z16) {
                    QZAlbumxUploadQualitySelectBarPart.ga(QZAlbumxUploadQualitySelectBarPart.this, z16);
                }
            });
            na();
            DynamicArrayList<String> value = S9().P1().getValue();
            if (value != null) {
                LiveData<ArrayList<String>> liveData = value.getLiveData();
                LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
                final Function1<ArrayList<String>, Unit> function1 = new Function1<ArrayList<String>, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadQualitySelectBarPart$onInitView$1$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ArrayList<String> arrayList) {
                        invoke2(arrayList);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ArrayList<String> arrayList) {
                        QZAlbumxUploadQualitySelectBarPart.this.na();
                    }
                };
                liveData.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.i
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        QZAlbumxUploadQualitySelectBarPart.ha(Function1.this, obj);
                    }
                });
            }
            RelativeLayout relativeLayout4 = this.qualityBarLayout;
            if (relativeLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qualityBarLayout");
            } else {
                relativeLayout2 = relativeLayout4;
            }
            fo.c.n(relativeLayout2, "em_qz_pic_quality_select");
            Y9();
            Z9(rootView);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(Intent newIntent) {
        super.onNewIntent(newIntent);
        na();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        if (N9() || !VipNtMMKV.INSTANCE.getCommon(LoginData.getInstance().getUinString()).decodeBool("qzone_request_real_vip", false)) {
            return;
        }
        ja();
    }

    private final void da(Intent data) {
        if (data == null) {
            return;
        }
        int intExtra = data.getIntExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_QUALITY", V9().getCurrentImageUploadQuality());
        int intExtra2 = data.getIntExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_VIDEO_QUALITY", V9().getCurrentVideoUploadQuality());
        if (intExtra != V9().getCurrentImageUploadQuality()) {
            V9().k2(intExtra);
            u5.b.L0("photo", V9().getCurrentImageUploadQuality(), LoginData.getInstance().getUin());
        }
        if (intExtra2 != V9().getCurrentVideoUploadQuality()) {
            V9().l2(intExtra2);
            u5.b.L0("video", V9().getCurrentVideoUploadQuality(), LoginData.getInstance().getUin());
        }
        na();
    }
}
