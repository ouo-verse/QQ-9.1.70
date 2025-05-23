package com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.protobuf.nano.MessageNano;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.banner.BannerLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanShareApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ShareScene;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanShareItem;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanShareTemplateConfig;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicActionSheet;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.MultiPicShareAdapter;
import com.tencent.sqshow.zootopia.nativeui.view.page.ZPlanAvatarPreDownloadManager;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\u0018\u0000 ]2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001^B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b[\u0010\\J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0007H\u0002J\u0013\u0010#\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\nH\u0002J\b\u0010&\u001a\u00020\u001fH\u0014J\b\u0010'\u001a\u00020\u001fH\u0014J\b\u0010(\u001a\u00020\u0007H\u0016J\b\u0010)\u001a\u00020\u0005H\u0014J\u000e\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u001cJ\u000e\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,J\u0010\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020/H\u0016J\u0018\u00105\u001a\u00020\u00072\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u001fH\u0016J\n\u00106\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u00107\u001a\u00020\u0007H\u0016J(\u0010;\u001a\u00020\u00072\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001cH\u0016J\u0013\u0010<\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010$R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010=R\u001e\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010?R\u001e\u0010B\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010?R\u001e\u0010D\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010?R\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010KR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000b0M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010NR\u0016\u0010Q\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010PR\u0016\u0010T\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010SR\u0016\u0010W\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006_"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/GeneralAvatarShareWithPicActionSheet;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/n;", "Lji3/h;", "Lji3/e;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "K0", "L0", "", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/s;", "F0", "view", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "J0", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Landroid/graphics/Bitmap;", "z0", "Landroid/content/Context;", "context", "Landroid/app/Activity;", "H0", "", "", "", "M0", "", "G0", "I0", "N0", "S0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "E0", "I", "G", "show", BdhLogUtil.LogTag.Tag_Conn, "dressKey", "Q0", "Lqu4/a;", "avatarCharacter", "P0", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/m;", "presenter", "R0", "Landroid/graphics/drawable/Drawable;", "drawable", "id", "O0", "getPoster", "dismiss", "", "success", "path", "b", "c", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/m;", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "mWeakActivity", "Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", "mSharePictureRecyclerViewRef", "Landroid/widget/LinearLayout;", "actionSheetLayoutWeakRef", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", "mSharePictureRecyclerView", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/MultiPicShareAdapter;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/MultiPicShareAdapter;", "adapter", "", "Ljava/util/List;", "shareDataList", "Z", "hasScrolled", "", "J", "startRecordTime", "T0", "Ljava/lang/String;", "currentDressKey", "U0", "Lqu4/a;", "currentAvatarCharacter", "<init>", "(Landroid/content/Context;)V", "V0", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GeneralAvatarShareWithPicActionSheet extends ShareActionSheetV2 implements n, ji3.h, ji3.e {

    /* renamed from: J0, reason: from kotlin metadata */
    private m presenter;

    /* renamed from: K0, reason: from kotlin metadata */
    private WeakReference<Activity> mWeakActivity;

    /* renamed from: L0, reason: from kotlin metadata */
    private WeakReference<BannerLayout> mSharePictureRecyclerViewRef;

    /* renamed from: M0, reason: from kotlin metadata */
    private WeakReference<LinearLayout> actionSheetLayoutWeakRef;

    /* renamed from: N0, reason: from kotlin metadata */
    private ZplanViewReportHelper reportHelper;

    /* renamed from: O0, reason: from kotlin metadata */
    private BannerLayout mSharePictureRecyclerView;

    /* renamed from: P0, reason: from kotlin metadata */
    private MultiPicShareAdapter adapter;

    /* renamed from: Q0, reason: from kotlin metadata */
    private List<PicShareData> shareDataList;

    /* renamed from: R0, reason: from kotlin metadata */
    private boolean hasScrolled;

    /* renamed from: S0, reason: from kotlin metadata */
    private long startRecordTime;

    /* renamed from: T0, reason: from kotlin metadata */
    private String currentDressKey;

    /* renamed from: U0, reason: from kotlin metadata */
    private qu4.a currentAvatarCharacter;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/GeneralAvatarShareWithPicActionSheet$b", "Lpg1/d;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends pg1.d {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/GeneralAvatarShareWithPicActionSheet$b$a", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "state", "", "onPageScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class a extends ViewPager2.OnPageChangeCallback {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ GeneralAvatarShareWithPicActionSheet f371743b;

            a(GeneralAvatarShareWithPicActionSheet generalAvatarShareWithPicActionSheet) {
                this.f371743b = generalAvatarShareWithPicActionSheet;
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                this.f371743b.hasScrolled = true;
            }
        }

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(View page, float f16) {
            Intrinsics.checkNotNullParameter(page, "page");
            int height = page.getHeight();
            int width = page.getWidth();
            int b16 = height - com.tencent.sqshow.zootopia.utils.i.b(52);
            page.setTranslationX(f16 * (-((width - ((b16 * 9) / 16)) - ((b16 * 10) / 427))));
        }

        @Override // pg1.d
        public void a(ViewPager2 viewPager2, RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            com.tencent.mobileqq.guild.component.banner.viewpager2.b.d(viewPager2, 0.5f);
            viewPager2.setOffscreenPageLimit(2);
            recyclerView.setOverScrollMode(2);
            viewPager2.setClipToPadding(false);
            viewPager2.setClipChildren(false);
            viewPager2.setPageTransformer(new ViewPager2.PageTransformer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.f
                @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
                public final void transformPage(View view, float f16) {
                    GeneralAvatarShareWithPicActionSheet.b.d(view, f16);
                }
            });
            viewPager2.registerOnPageChangeCallback(new a(GeneralAvatarShareWithPicActionSheet.this));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GeneralAvatarShareWithPicActionSheet(Context context) {
        super(r0);
        Intrinsics.checkNotNullParameter(context, "context");
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        this.mWeakActivity = new WeakReference<>(H0(context));
        this.reportHelper = new ZplanViewReportHelper();
        this.shareDataList = new ArrayList();
        this.currentDressKey = "";
        F0();
        ((IZPlanShareApi) QRoute.api(IZPlanShareApi.class)).setPreRecordShareListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(GeneralAvatarShareWithPicActionSheet this$0, View view, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        Intrinsics.checkNotNullExpressionValue(item, "item");
        Intrinsics.checkNotNullExpressionValue(shareActionSheet, "shareActionSheet");
        this$0.J0(view, item, shareActionSheet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(GeneralAvatarShareWithPicActionSheet this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView cancel = this$0.P;
        if (cancel != null) {
            ZplanViewReportHelper zplanViewReportHelper = this$0.reportHelper;
            Intrinsics.checkNotNullExpressionValue(cancel, "cancel");
            zplanViewReportHelper.e(cancel, SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, this$0.M0());
        }
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(GeneralAvatarShareWithPicActionSheet this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m mVar = this$0.presenter;
        if (mVar != null) {
            mVar.destroy();
        }
        ((IZPlanShareApi) QRoute.api(IZPlanShareApi.class)).setPreRecordShareListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D0(GeneralAvatarShareWithPicActionSheet this$0, DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 4) {
            return false;
        }
        this$0.N0();
        return false;
    }

    private final List<Integer> E0() {
        List<Integer> listOf;
        Object orNull;
        ArrayList arrayList = new ArrayList();
        try {
            ZPlanShareTemplateConfig zPlanShareTemplateConfig = ZPlanQQMC.INSTANCE.getZPlanShareTemplateConfig();
            Map<Integer, List<Integer>> b16 = zPlanShareTemplateConfig.b();
            ShareScene shareScene = ShareScene.CHANGE_DRESS;
            if (!b16.containsKey(Integer.valueOf(shareScene.getValue()))) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(0);
            } else {
                listOf = zPlanShareTemplateConfig.b().get(Integer.valueOf(shareScene.getValue()));
                if (listOf == null) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(0);
                }
            }
            List<ZPlanShareItem> a16 = zPlanShareTemplateConfig.a();
            if (a16.isEmpty()) {
                a16 = CollectionsKt__CollectionsJVMKt.listOf(new ZPlanShareItem(0, null, null, null, null, null, null, 127, null));
            }
            List<ZPlanShareItem> list = a16;
            Iterator<Integer> it = listOf.iterator();
            while (it.hasNext()) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(list, it.next().intValue());
                ZPlanShareItem zPlanShareItem = (ZPlanShareItem) orNull;
                if (zPlanShareItem != null) {
                    int actionID = zPlanShareItem.getActionID();
                    if (!arrayList.contains(Integer.valueOf(actionID))) {
                        arrayList.add(Integer.valueOf(actionID));
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e("GeneralAvatarShareWithPicActionSheet", 1, "findRecordIdList error wrong config t:" + th5);
        }
        return arrayList;
    }

    private final List<PicShareData> F0() {
        List<Integer> listOf;
        Object orNull;
        try {
            ZPlanShareTemplateConfig zPlanShareTemplateConfig = ZPlanQQMC.INSTANCE.getZPlanShareTemplateConfig();
            Map<Integer, List<Integer>> b16 = zPlanShareTemplateConfig.b();
            ShareScene shareScene = ShareScene.CHANGE_DRESS;
            if (!b16.containsKey(Integer.valueOf(shareScene.getValue()))) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(0);
            } else {
                listOf = zPlanShareTemplateConfig.b().get(Integer.valueOf(shareScene.getValue()));
                if (listOf == null) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(0);
                }
            }
            List<ZPlanShareItem> a16 = zPlanShareTemplateConfig.a();
            if (a16.isEmpty()) {
                a16 = CollectionsKt__CollectionsJVMKt.listOf(new ZPlanShareItem(0, null, null, null, null, null, null, 127, null));
            }
            List<ZPlanShareItem> list = a16;
            Iterator<Integer> it = listOf.iterator();
            while (it.hasNext()) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(list, it.next().intValue());
                ZPlanShareItem zPlanShareItem = (ZPlanShareItem) orNull;
                if (zPlanShareItem != null) {
                    this.shareDataList.add(new PicShareData(null, zPlanShareItem.getActionID(), zPlanShareItem, null, null, 25, null));
                }
            }
        } catch (Throwable th5) {
            QLog.e("GeneralAvatarShareWithPicActionSheet", 1, "generateShareDataList error wrong config t:" + th5);
        }
        return this.shareDataList;
    }

    private final int G0() {
        ViewPager2 viewPager2;
        Object orNull;
        BannerLayout bannerLayout = this.mSharePictureRecyclerView;
        if (bannerLayout == null || (viewPager2 = bannerLayout.getViewPager2()) == null) {
            return 0;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.shareDataList, viewPager2.getCurrentItem());
        PicShareData picShareData = (PicShareData) orNull;
        if (picShareData == null) {
            return 0;
        }
        return picShareData.getActionId();
    }

    private final Activity H0(Context context) {
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return H0(((ContextWrapper) context).getBaseContext());
    }

    private final int I0() {
        ViewPager2 viewPager2;
        BannerLayout bannerLayout = this.mSharePictureRecyclerView;
        if (bannerLayout == null || (viewPager2 = bannerLayout.getViewPager2()) == null) {
            return 0;
        }
        return viewPager2.getCurrentItem();
    }

    private final void J0(View view, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        ViewPager2 viewPager2;
        Object orNull;
        Map mapOf;
        Map<String, ? extends Object> plus;
        Map mapOf2;
        Map<String, ? extends Object> plus2;
        Map mapOf3;
        Map<String, ? extends Object> plus3;
        Map mapOf4;
        Map<String, ? extends Object> plus4;
        Map mapOf5;
        Map<String, ? extends Object> plus5;
        Map mapOf6;
        Map<String, ? extends Object> plus6;
        Map mapOf7;
        Map<String, ? extends Object> plus7;
        Map mapOf8;
        Map<String, ? extends Object> plus8;
        Activity activity = this.mWeakActivity.get();
        if (activity == null) {
            QLog.e("GeneralAvatarShareWithPicActionSheet", 1, "handleItemClick Error, mActivity == null");
            return;
        }
        BannerLayout bannerLayout = this.mSharePictureRecyclerView;
        if (bannerLayout == null || (viewPager2 = bannerLayout.getViewPager2()) == null) {
            return;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.shareDataList, viewPager2.getCurrentItem());
        PicShareData picShareData = (PicShareData) orNull;
        if (picShareData == null) {
            return;
        }
        if (picShareData.getAvatarDrawable() != null && picShareData.getQrCodeBitmap() != null) {
            int i3 = item.action;
            if (i3 == 2) {
                ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_share_channel", 0));
                plus = MapsKt__MapsKt.plus(mapOf, M0());
                zplanViewReportHelper.e(view, "em_zplan_outfit_share_channel", plus);
                m mVar = this.presenter;
                if (mVar != null) {
                    mVar.c(activity);
                }
            } else if (i3 == 3) {
                ZplanViewReportHelper zplanViewReportHelper2 = this.reportHelper;
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_share_channel", 1));
                plus2 = MapsKt__MapsKt.plus(mapOf2, M0());
                zplanViewReportHelper2.e(view, "em_zplan_outfit_share_channel", plus2);
                m mVar2 = this.presenter;
                if (mVar2 != null) {
                    mVar2.b(activity);
                }
            } else if (i3 == 9) {
                ZplanViewReportHelper zplanViewReportHelper3 = this.reportHelper;
                mapOf3 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_share_channel", 4));
                plus3 = MapsKt__MapsKt.plus(mapOf3, M0());
                zplanViewReportHelper3.e(view, "em_zplan_outfit_share_channel", plus3);
                m mVar3 = this.presenter;
                if (mVar3 != null) {
                    mVar3.d(activity, item.action);
                }
            } else if (i3 == 10) {
                ZplanViewReportHelper zplanViewReportHelper4 = this.reportHelper;
                mapOf4 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_share_channel", 5));
                plus4 = MapsKt__MapsKt.plus(mapOf4, M0());
                zplanViewReportHelper4.e(view, "em_zplan_outfit_share_channel", plus4);
                m mVar4 = this.presenter;
                if (mVar4 != null) {
                    mVar4.d(activity, item.action);
                }
            } else if (i3 == 39) {
                ZplanViewReportHelper zplanViewReportHelper5 = this.reportHelper;
                mapOf5 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_share_channel", 3));
                plus5 = MapsKt__MapsKt.plus(mapOf5, M0());
                zplanViewReportHelper5.e(view, "em_zplan_outfit_share_channel", plus5);
                m mVar5 = this.presenter;
                if (mVar5 != null) {
                    mVar5.e();
                }
            } else if (i3 == 218) {
                ZplanViewReportHelper zplanViewReportHelper6 = this.reportHelper;
                mapOf6 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_share_channel", 8));
                plus6 = MapsKt__MapsKt.plus(mapOf6, M0());
                zplanViewReportHelper6.e(view, "em_zplan_outfit_share_channel", plus6);
                m mVar6 = this.presenter;
                if (mVar6 != null) {
                    mVar6.a(activity);
                }
            } else if (i3 == 204) {
                ZplanViewReportHelper zplanViewReportHelper7 = this.reportHelper;
                mapOf7 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_share_channel", 6));
                plus7 = MapsKt__MapsKt.plus(mapOf7, M0());
                zplanViewReportHelper7.e(view, "em_zplan_outfit_share_channel", plus7);
                m mVar7 = this.presenter;
                if (mVar7 != null) {
                    mVar7.g(activity);
                }
            } else if (i3 == 205) {
                ZplanViewReportHelper zplanViewReportHelper8 = this.reportHelper;
                mapOf8 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_share_channel", 7));
                plus8 = MapsKt__MapsKt.plus(mapOf8, M0());
                zplanViewReportHelper8.e(view, "em_zplan_outfit_share_channel", plus8);
                m mVar8 = this.presenter;
                if (mVar8 != null) {
                    mVar8.f(activity);
                }
            }
            dismiss();
            return;
        }
        QQToastUtil.showQQToast(1, R.string.xc_);
    }

    private final void L0(View rootView) {
        MultiPicShareAdapter multiPicShareAdapter;
        this.adapter = new MultiPicShareAdapter(this.shareDataList);
        this.mSharePictureRecyclerView = (BannerLayout) rootView.findViewById(R.id.ql5);
        this.mSharePictureRecyclerViewRef = new WeakReference<>(this.mSharePictureRecyclerView);
        BannerLayout bannerLayout = this.mSharePictureRecyclerView;
        if (bannerLayout == null || (multiPicShareAdapter = this.adapter) == null) {
            return;
        }
        bannerLayout.setAdapter(multiPicShareAdapter);
        bannerLayout.setLoop(false);
        bannerLayout.getViewPager2().setOrientation(0);
        bannerLayout.getStyleManager().a(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object S0(Continuation<? super Unit> continuation) {
        GeneralAvatarShareWithPicActionSheet$startRecord$1 generalAvatarShareWithPicActionSheet$startRecord$1;
        Object coroutine_suspended;
        int i3;
        gx4.a c16;
        String currentUin;
        if (continuation instanceof GeneralAvatarShareWithPicActionSheet$startRecord$1) {
            generalAvatarShareWithPicActionSheet$startRecord$1 = (GeneralAvatarShareWithPicActionSheet$startRecord$1) continuation;
            int i16 = generalAvatarShareWithPicActionSheet$startRecord$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                generalAvatarShareWithPicActionSheet$startRecord$1.label = i16 - Integer.MIN_VALUE;
                GeneralAvatarShareWithPicActionSheet$startRecord$1 generalAvatarShareWithPicActionSheet$startRecord$12 = generalAvatarShareWithPicActionSheet$startRecord$1;
                Object obj = generalAvatarShareWithPicActionSheet$startRecord$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = generalAvatarShareWithPicActionSheet$startRecord$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    this.startRecordTime = System.currentTimeMillis();
                    if (E0().isEmpty()) {
                        return Unit.INSTANCE;
                    }
                    qu4.a aVar = this.currentAvatarCharacter;
                    if (aVar != null) {
                        try {
                            c16 = gx4.a.c(MessageNano.toByteArray(aVar));
                        } catch (Exception unused) {
                            QLog.e("GeneralAvatarShareWithPicActionSheet", 1, "convert AvatarCharacter error");
                        }
                        AvatarCharacterInfo avatarCharacterInfo = c16 != null ? new AvatarCharacterInfo(c16, this.currentDressKey) : null;
                        currentUin = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getCurrentUin();
                        if (currentUin != null) {
                            IZPlanShareApi iZPlanShareApi = (IZPlanShareApi) QRoute.api(IZPlanShareApi.class);
                            Priority priority = Priority.HIGH;
                            generalAvatarShareWithPicActionSheet$startRecord$12.label = 1;
                            if (iZPlanShareApi.preRecordSharePics(currentUin, priority, avatarCharacterInfo, this, generalAvatarShareWithPicActionSheet$startRecord$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    c16 = null;
                    AvatarCharacterInfo avatarCharacterInfo2 = c16 != null ? new AvatarCharacterInfo(c16, this.currentDressKey) : null;
                    currentUin = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getCurrentUin();
                    if (currentUin != null) {
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        generalAvatarShareWithPicActionSheet$startRecord$1 = new GeneralAvatarShareWithPicActionSheet$startRecord$1(this, continuation);
        GeneralAvatarShareWithPicActionSheet$startRecord$1 generalAvatarShareWithPicActionSheet$startRecord$122 = generalAvatarShareWithPicActionSheet$startRecord$1;
        Object obj2 = generalAvatarShareWithPicActionSheet$startRecord$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = generalAvatarShareWithPicActionSheet$startRecord$122.label;
        if (i3 != 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2
    public View C() {
        View C = super.C();
        Intrinsics.checkNotNullExpressionValue(C, "super.createViewFlipper()");
        java.lang.ref.WeakReference<Context> weakReference = this.f317430e;
        if (weakReference != null && weakReference.get() != null) {
            View findViewById = C.findViewById(R.id.p9v);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.action_sheet_layout)");
            this.actionSheetLayoutWeakRef = new WeakReference<>((LinearLayout) findViewById);
            L0(C);
            setItemClickListenerV3(new ShareActionSheet.c() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.b
                @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
                public final void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                    GeneralAvatarShareWithPicActionSheet.A0(GeneralAvatarShareWithPicActionSheet.this, view, actionSheetItem, shareActionSheet);
                }
            });
            this.P.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GeneralAvatarShareWithPicActionSheet.B0(GeneralAvatarShareWithPicActionSheet.this, view);
                }
            });
            setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.d
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    GeneralAvatarShareWithPicActionSheet.C0(GeneralAvatarShareWithPicActionSheet.this, dialogInterface);
                }
            });
            this.F.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.e
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                    boolean D0;
                    D0 = GeneralAvatarShareWithPicActionSheet.D0(GeneralAvatarShareWithPicActionSheet.this, dialogInterface, i3, keyEvent);
                    return D0;
                }
            });
            K0(C);
        }
        return C;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2
    protected int G() {
        return R.id.p9v;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2
    protected int I() {
        return R.layout.dci;
    }

    public void O0(Drawable drawable, int id5) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        List<PicShareData> list = this.shareDataList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((PicShareData) obj).getActionId() == id5) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PicShareData) it.next()).f(drawable);
        }
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicActionSheet$setAvatar$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                MultiPicShareAdapter multiPicShareAdapter;
                multiPicShareAdapter = GeneralAvatarShareWithPicActionSheet.this.adapter;
                if (multiPicShareAdapter != null) {
                    multiPicShareAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    public final void P0(qu4.a avatarCharacter) {
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        this.currentAvatarCharacter = avatarCharacter;
    }

    public final void Q0(String dressKey) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        this.currentDressKey = dressKey;
    }

    public void R0(m presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.presenter = presenter;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
    
        if (r0 == false) goto L14;
     */
    @Override // ji3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(final boolean success, final String path, final int id5, String dressKey) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        if (!(dressKey.length() == 0)) {
            if (!Intrinsics.areEqual(dressKey, this.currentDressKey)) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.currentDressKey, dressKey, false, 2, null);
            }
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicActionSheet$onResp$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    long j3;
                    long j16;
                    if (success) {
                        long currentTimeMillis = System.currentTimeMillis();
                        j16 = this.startRecordTime;
                        QLog.d("GeneralAvatarShareWithPicActionSheet", 1, "success OnRespCost:" + (currentTimeMillis - j16) + "ms id:" + id5);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mRequestWidth = com.tencent.sqshow.zootopia.utils.i.b(300);
                        obtain.mRequestHeight = com.tencent.sqshow.zootopia.utils.i.b(534);
                        obtain.mLoadingDrawable = new ColorDrawable(0);
                        obtain.mUseSharpPAnimImage = true;
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("key_double_bitmap", true);
                        obtain.mExtraInfo = bundle;
                        URLDrawable drawable = URLDrawable.getFileDrawable(path, obtain);
                        GeneralAvatarShareWithPicActionSheet generalAvatarShareWithPicActionSheet = this;
                        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
                        generalAvatarShareWithPicActionSheet.O0(drawable, id5);
                        return;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    j3 = this.startRecordTime;
                    QLog.d("GeneralAvatarShareWithPicActionSheet", 1, "fail OnRespCost:" + (currentTimeMillis2 - j3) + "ms");
                }
            });
            return;
        }
        QLog.e("GeneralAvatarShareWithPicActionSheet", 1, "success but dressKey:" + dressKey + "  currentDressKey:" + this.currentDressKey + "  return");
    }

    @Override // ji3.h
    public Object c(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object S0 = S0(continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return S0 == coroutine_suspended ? S0 : Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2, com.tencent.mobileqq.widget.share.ShareActionSheet
    public void dismiss() {
        ShareActionSheetV2.Param param = this.f317428d;
        if (param != null) {
            param.context = null;
        }
        N0();
        super.dismiss();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.n
    public Bitmap getPoster() {
        ViewPager2 viewPager2;
        BannerLayout bannerLayout = this.mSharePictureRecyclerView;
        if (bannerLayout == null || (viewPager2 = bannerLayout.getViewPager2()) == null) {
            return null;
        }
        return z0(viewPager2);
    }

    private final Map<String, Object> M0() {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ACTION_ID, Integer.valueOf(G0())), TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ZPlanAvatarPreDownloadManager.f371947a.h()), TuplesKt.to("zplan_is_slide", Integer.valueOf(this.hasScrolled ? 1 : 0)), TuplesKt.to("zplan_poster_location", Integer.valueOf(I0())));
        return mutableMapOf;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2, com.tencent.mobileqq.widget.share.ShareActionSheet
    public void show() {
        super.show(false);
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicActionSheet$show$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                java.lang.ref.WeakReference weakReference;
                WeakReference weakReference2;
                WeakReference weakReference3;
                weakReference = ((ShareActionSheetV2) GeneralAvatarShareWithPicActionSheet.this).f317430e;
                Context context = weakReference != null ? (Context) weakReference.get() : null;
                weakReference2 = GeneralAvatarShareWithPicActionSheet.this.mSharePictureRecyclerViewRef;
                BannerLayout bannerLayout = weakReference2 != null ? (BannerLayout) weakReference2.get() : null;
                weakReference3 = GeneralAvatarShareWithPicActionSheet.this.actionSheetLayoutWeakRef;
                LinearLayout linearLayout = weakReference3 != null ? (LinearLayout) weakReference3.get() : null;
                if (context == null || bannerLayout == null || linearLayout == null) {
                    return;
                }
                bannerLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.f154349j6));
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, linearLayout.getHeight(), 0.0f);
                translateAnimation.setFillEnabled(true);
                translateAnimation.setStartTime(300L);
                translateAnimation.setDuration(300L);
                linearLayout.startAnimation(translateAnimation);
            }
        });
    }

    private final void K0(View rootView) {
        Map mapOf;
        Map plus;
        Activity activity = this.mWeakActivity.get();
        if (activity != null) {
            this.reportHelper.a(activity, rootView, "pg_zplan_avatar_outfit_share", M0());
        }
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        ImageView cancel = this.P;
        Intrinsics.checkNotNullExpressionValue(cancel, "cancel");
        zplanViewReportHelper.g(cancel, SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, (r16 & 4) != 0 ? null : M0(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ZplanViewReportHelper zplanViewReportHelper2 = this.reportHelper;
        GridView grid_row_view1 = this.f317443m0;
        Intrinsics.checkNotNullExpressionValue(grid_row_view1, "grid_row_view1");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_share_channel", 0));
        plus = MapsKt__MapsKt.plus(mapOf, M0());
        zplanViewReportHelper2.g(grid_row_view1, "em_zplan_outfit_share_channel", (r16 & 4) != 0 ? null : plus, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        BannerLayout bannerLayout = this.mSharePictureRecyclerView;
        if (bannerLayout != null) {
            this.reportHelper.g(bannerLayout, "em_zplan_share_poster", (r16 & 4) != 0 ? null : M0(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    private final void N0() {
        Map mapOf;
        Map plus;
        Map mapOf2;
        ImageView imageView = this.P;
        if (imageView != null) {
            ZplanViewReportHelper.j(this.reportHelper, imageView, SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, M0(), false, null, 16, null);
        }
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        GridView grid_row_view1 = this.f317443m0;
        Intrinsics.checkNotNullExpressionValue(grid_row_view1, "grid_row_view1");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_share_channel", 0));
        plus = MapsKt__MapsKt.plus(mapOf, M0());
        ZplanViewReportHelper.j(zplanViewReportHelper, grid_row_view1, "em_zplan_outfit_share_channel", plus, false, null, 16, null);
        BannerLayout bannerLayout = this.mSharePictureRecyclerView;
        if (bannerLayout != null) {
            ZplanViewReportHelper.j(this.reportHelper, bannerLayout, "em_zplan_share_poster", M0(), false, null, 16, null);
        }
        VideoReport.setPageId(getActionSheet(), "pg_zplan_avatar_outfit_share");
        ActionSheet actionSheet = getActionSheet();
        mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "GeneralAvatarShareWithPicActionSheet"));
        VideoReport.reportEvent("pgout", actionSheet, mapOf2);
    }

    private final Bitmap z0(ViewPager2 viewPager2) {
        RecyclerView recyclerView;
        View childAt;
        try {
            View childAt2 = viewPager2.getChildAt(0);
            recyclerView = childAt2 instanceof RecyclerView ? (RecyclerView) childAt2 : null;
            childAt = recyclerView != null ? recyclerView.getChildAt(viewPager2.getCurrentItem()) : null;
        } catch (Throwable th5) {
            QLog.e("GeneralAvatarShareWithPicActionSheet", 1, "captureViewPager2Page failed t:" + th5);
        }
        if (childAt == null) {
            return null;
        }
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
        MultiPicShareAdapter.b bVar = childViewHolder instanceof MultiPicShareAdapter.b ? (MultiPicShareAdapter.b) childViewHolder : null;
        if (bVar != null) {
            ConstraintLayout constraintLayout = bVar.getBinding().f418827c;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "vh.binding.bg");
            bVar.getBinding().f418831g.setVisibility(8);
            if (constraintLayout.getWidth() > 0 && constraintLayout.getHeight() > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(constraintLayout.getWidth(), constraintLayout.getHeight(), Bitmap.Config.ARGB_8888);
                constraintLayout.draw(new Canvas(createBitmap));
                return createBitmap;
            }
            return null;
        }
        return null;
    }
}
