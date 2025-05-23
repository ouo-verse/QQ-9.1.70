package com.qzone.reborn.part.publish.mood.imageai;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import cm.b;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity;
import com.qzone.reborn.part.publish.mood.imageai.e;
import com.qzone.util.am;
import com.qzone.widget.ExtendEditText;
import com.qzone.widget.MoodPicLabel;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import qshadow.QZoneAutoTexting$TextInfo;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 Y2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Z[B\u000f\u0012\u0006\u0010+\u001a\u00020(\u00a2\u0006\u0004\bW\u0010XJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0003J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J-\u0010\u0015\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010 \u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\u0012\u0010'\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%H\u0016R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010I\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010ER\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010LR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010U\u00a8\u0006\\"}, d2 = {"Lcom/qzone/reborn/part/publish/mood/imageai/QZonePublishPicToTextPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "Lcm/b$c;", "Lcom/qzone/reborn/part/publish/mood/imageai/e$b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "O9", "initViewModel", "L9", "W9", "X9", "aa", "", "J9", "V9", "view", "", AdMetricTag.Report.TYPE, "clickPos", "T9", "(Landroid/view/View;ILjava/lang/Integer;)V", "R9", "Q9", "S9", "P9", "Y9", "K9", "", "isPartEnable", "onInitView", NodeProps.ON_CLICK, "Lqshadow/QZoneAutoTexting$TextInfo;", "data", "F5", UserInfo.SEX_FEMALE, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/qzone/publish/ui/activity/QZonePublishMoodNewStyleActivity;", "d", "Lcom/qzone/publish/ui/activity/QZonePublishMoodNewStyleActivity;", "publishActivity", "Lcom/qzone/reborn/part/publish/mood/imageai/l;", "e", "Lcom/qzone/reborn/part/publish/mood/imageai/l;", "mPublishViewModel", "Lgm/c;", "f", "Lgm/c;", "mSelectPhotoViewModel", "Lbm/a;", tl.h.F, "Lbm/a;", "mTextContentViewModel", "i", "Landroid/view/View;", "mPicToTextMaskView", "Lcom/qzone/widget/MoodPicLabel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/widget/MoodPicLabel;", "mPicToTextLabel", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", "mGuideContainerView", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mGuideLeftView", "E", "mGuideLinkView", "mGuideOpenView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "mGuideCloseView", "H", "mGuideBgView", "Lcom/qzone/reborn/part/publish/mood/imageai/e;", "I", "Lcom/qzone/reborn/part/publish/mood/imageai/e;", "mHalfScreenFloatDialog", "J", "Z", "mIsAppendAiTextTail", "<init>", "(Lcom/qzone/publish/ui/activity/QZonePublishMoodNewStyleActivity;)V", "K", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePublishPicToTextPart extends com.qzone.reborn.base.k implements View.OnClickListener, b.c, e.b {

    /* renamed from: C, reason: from kotlin metadata */
    private FrameLayout mGuideContainerView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mGuideLeftView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mGuideLinkView;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mGuideOpenView;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mGuideCloseView;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView mGuideBgView;

    /* renamed from: I, reason: from kotlin metadata */
    private e mHalfScreenFloatDialog;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mIsAppendAiTextTail;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZonePublishMoodNewStyleActivity publishActivity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private l mPublishViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private gm.c mSelectPhotoViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private bm.a mTextContentViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mPicToTextMaskView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MoodPicLabel mPicToTextLabel;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/part/publish/mood/imageai/QZonePublishPicToTextPart$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "Lmqq/util/WeakReference;", "Lcom/qzone/reborn/part/publish/mood/imageai/QZonePublishPicToTextPart;", "a", "Lmqq/util/WeakReference;", "mWeakReference", "part", "<init>", "(Lcom/qzone/reborn/part/publish/mood/imageai/QZonePublishPicToTextPart;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QZonePublishPicToTextPart> mWeakReference;

        public b(QZonePublishPicToTextPart part) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.mWeakReference = new WeakReference<>(part);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            HashMap hashMap = new HashMap();
            QZonePublishPicToTextPart qZonePublishPicToTextPart = this.mWeakReference.get();
            if (qZonePublishPicToTextPart != null) {
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.BUTTON_STATE, Integer.valueOf(!TextUtils.isEmpty(qZonePublishPicToTextPart.J9()) ? 1 : 0));
            }
            return hashMap;
        }
    }

    public QZonePublishPicToTextPart(QZonePublishMoodNewStyleActivity publishActivity) {
        Intrinsics.checkNotNullParameter(publishActivity, "publishActivity");
        this.publishActivity = publishActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String J9() {
        ArrayList<String> V;
        e9.a aVar = this.publishActivity.T;
        if (aVar != null && (V = aVar.V()) != null) {
            int i3 = 0;
            for (Object obj : V) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                String str = (String) obj;
                if (!TextUtils.isEmpty(str) && !aVar.h0(i3) && !o7.b.b(str)) {
                    QLog.i("QZonePublishPicToTextPart", 2, "get first image path" + str);
                    return str;
                }
                i3 = i16;
            }
        }
        return null;
    }

    private final void K9() {
        ExtendEditText extendEditText = this.publishActivity.f45104j0;
        if (extendEditText != null) {
            extendEditText.requestFocus();
        }
    }

    private final void L9() {
        FrameLayout frameLayout = null;
        if (f.f58673a.g()) {
            FrameLayout frameLayout2 = this.mGuideContainerView;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuideContainerView");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.setVisibility(8);
            return;
        }
        FrameLayout frameLayout3 = this.mGuideContainerView;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideContainerView");
        } else {
            frameLayout = frameLayout3;
        }
        if (frameLayout.getVisibility() == 0) {
            QLog.e("QZonePublishPicToTextPart", 1, "[initGuideBubbleView] is showed guide");
        } else {
            W9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void P9() {
        String J9 = J9();
        if (TextUtils.isEmpty(J9)) {
            QQToastUtil.showQQToast(0, R.string.f2198667k);
            return;
        }
        f.f58673a.i();
        FrameLayout frameLayout = this.mGuideContainerView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideContainerView");
            frameLayout = null;
        }
        frameLayout.setVisibility(8);
        aa();
        Y9();
        l lVar = this.mPublishViewModel;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishViewModel");
            lVar = null;
        }
        l.e2(lVar, J9, null, null, 6, null);
    }

    private final void Q9() {
        FrameLayout frameLayout = this.mGuideContainerView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideContainerView");
            frameLayout = null;
        }
        frameLayout.setVisibility(8);
    }

    private final void R9() {
        ho.i.q(getContext(), "https://rule.tencent.com/rule/202409050001");
    }

    private final void S9() {
        if (!f.f58673a.f()) {
            QLog.i("QZonePublishPicToTextPart", 1, "[onHandleClickLabel] is not granted");
            W9();
        } else {
            P9();
        }
    }

    private final void T9(View view, int reportType, Integer clickPos) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (clickPos != null) {
            linkedHashMap.put("click_pos", clickPos);
        }
        fo.b j3 = new fo.b().l(linkedHashMap).j(EndExposurePolicy.REPORT_NONE);
        if (reportType == 0) {
            j3.k(ExposurePolicy.REPORT_NONE);
            j3.g(ClickPolicy.REPORT_ALL);
        } else if (reportType == 1) {
            j3.k(ExposurePolicy.REPORT_ALL);
            j3.g(ClickPolicy.REPORT_NONE);
        }
        fo.c.o(view, "em_qz_pic_generate_text_authorization", j3);
    }

    private final void V9() {
        fo.b h16 = new fo.b().j(EndExposurePolicy.REPORT_NONE).h(new b(this));
        MoodPicLabel moodPicLabel = this.mPicToTextLabel;
        if (moodPicLabel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicToTextLabel");
            moodPicLabel = null;
        }
        fo.c.o(moodPicLabel, "em_qz_pic_generate_text", h16);
    }

    private final void W9() {
        TextView textView;
        f fVar = f.f58673a;
        fVar.j();
        FrameLayout frameLayout = this.mGuideContainerView;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideContainerView");
            frameLayout = null;
        }
        frameLayout.setVisibility(0);
        Option url = Option.obtain().setUrl("https://qzonestyle.gtimg.cn/qzone/client/mqq/publisher/qzone_publish_pic_to_text_guide_bg.png");
        ImageView imageView = this.mGuideBgView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideBgView");
            imageView = null;
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(url.setTargetView(imageView).setLoadingDrawableId(R.drawable.trans).setFailedDrawableId(R.drawable.trans));
        TextView textView2 = this.mGuideLeftView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideLeftView");
            textView2 = null;
        }
        textView2.setText(com.qzone.reborn.configx.g.f53821a.b().i1());
        if (FontSettingManager.isFontSizeLarge()) {
            pl.a aVar = pl.a.f426446a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (!aVar.z(context)) {
                TextView textView3 = this.mGuideLeftView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGuideLeftView");
                    textView3 = null;
                }
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                textView3.setMaxWidth(fVar.d(context2));
            }
        }
        TextView textView4 = this.mGuideLeftView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideLeftView");
            textView = null;
        } else {
            textView = textView4;
        }
        U9(this, textView, 1, null, 4, null);
        TextView textView5 = this.mGuideOpenView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideOpenView");
            textView5 = null;
        }
        T9(textView5, 0, 2);
        TextView textView6 = this.mGuideLinkView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideLinkView");
            textView6 = null;
        }
        T9(textView6, 0, 3);
        ImageView imageView2 = this.mGuideCloseView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideCloseView");
            imageView2 = null;
        }
        T9(imageView2, 0, 1);
        FrameLayout frameLayout3 = this.mGuideContainerView;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideContainerView");
        } else {
            frameLayout2 = frameLayout3;
        }
        T9(frameLayout2, 0, 0);
    }

    private final void X9() {
        MoodPicLabel moodPicLabel = this.mPicToTextLabel;
        MoodPicLabel moodPicLabel2 = null;
        if (moodPicLabel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicToTextLabel");
            moodPicLabel = null;
        }
        TextView b16 = moodPicLabel.b();
        if (b16 != null) {
            b16.setText(com.qzone.reborn.configx.g.f53821a.b().m1());
        }
        Option url = Option.obtain().setUrl(com.qzone.reborn.configx.g.f53821a.b().n1());
        MoodPicLabel moodPicLabel3 = this.mPicToTextLabel;
        if (moodPicLabel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicToTextLabel");
        } else {
            moodPicLabel2 = moodPicLabel3;
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(url.setTargetView(moodPicLabel2.a()).setLoadingDrawableId(R.drawable.trans).setFailedDrawableId(R.drawable.trans));
        aa();
        V9();
    }

    private final void Y9() {
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        TextView textView = this.mGuideOpenView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideOpenView");
            textView = null;
        }
        e eVar = new e(activity, textView);
        this.mHalfScreenFloatDialog = eVar;
        eVar.r0(this);
        eVar.s0(this);
        eVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qzone.reborn.part.publish.mood.imageai.i
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                QZonePublishPicToTextPart.Z9(QZonePublishPicToTextPart.this, dialogInterface);
            }
        });
        eVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(QZonePublishPicToTextPart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa() {
        boolean z16 = !TextUtils.isEmpty(J9());
        QLog.i("QZonePublishPicToTextPart", 1, "[updateLabelView] hasFirstImage=" + z16);
        int i3 = z16 ? R.color.qui_common_text_primary : R.color.qui_common_text_tertiary;
        MoodPicLabel moodPicLabel = this.mPicToTextLabel;
        MoodPicLabel moodPicLabel2 = null;
        if (moodPicLabel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicToTextLabel");
            moodPicLabel = null;
        }
        ImageView a16 = moodPicLabel.a();
        if (a16 != null) {
            a16.setAlpha(z16 ? 1.0f : 0.3f);
        }
        Context context = getContext();
        if (context != null) {
            int color = context.getColor(i3);
            MoodPicLabel moodPicLabel3 = this.mPicToTextLabel;
            if (moodPicLabel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPicToTextLabel");
            } else {
                moodPicLabel2 = moodPicLabel3;
            }
            TextView b16 = moodPicLabel2.b();
            if (b16 != null) {
                b16.setTextColor(color);
            }
        }
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(l.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZonePublis\u2026extViewModel::class.java)");
        this.mPublishViewModel = (l) viewModel;
        ViewModel viewModel2 = getViewModel(gm.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneSelect\u2026otoViewModel::class.java)");
        this.mSelectPhotoViewModel = (gm.c) viewModel2;
        ViewModel viewModel3 = getViewModel(bm.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "getViewModel(QZoneTextCo\u2026entViewModel::class.java)");
        this.mTextContentViewModel = (bm.a) viewModel3;
        l lVar = this.mPublishViewModel;
        gm.c cVar = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishViewModel");
            lVar = null;
        }
        MutableLiveData<List<QZoneAutoTexting$TextInfo>> U1 = lVar.U1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<? extends QZoneAutoTexting$TextInfo>, Unit> function1 = new Function1<List<? extends QZoneAutoTexting$TextInfo>, Unit>() { // from class: com.qzone.reborn.part.publish.mood.imageai.QZonePublishPicToTextPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends QZoneAutoTexting$TextInfo> list) {
                invoke2((List<QZoneAutoTexting$TextInfo>) list);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
            
                r0 = r1.this$0.mHalfScreenFloatDialog;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(List<QZoneAutoTexting$TextInfo> list) {
                e eVar;
                e eVar2;
                e eVar3;
                eVar = QZonePublishPicToTextPart.this.mHalfScreenFloatDialog;
                if (eVar != null) {
                    eVar2 = QZonePublishPicToTextPart.this.mHalfScreenFloatDialog;
                    Intrinsics.checkNotNull(eVar2);
                    if (!eVar2.isShowing() || eVar3 == null) {
                        return;
                    }
                    eVar3.c0(list);
                }
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.part.publish.mood.imageai.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePublishPicToTextPart.M9(Function1.this, obj);
            }
        });
        gm.c cVar2 = this.mSelectPhotoViewModel;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectPhotoViewModel");
        } else {
            cVar = cVar2;
        }
        MutableLiveData<DynamicArrayList<String>> S1 = cVar.S1();
        final QZonePublishPicToTextPart$initViewModel$2 qZonePublishPicToTextPart$initViewModel$2 = new QZonePublishPicToTextPart$initViewModel$2(this);
        S1.observeForever(new Observer() { // from class: com.qzone.reborn.part.publish.mood.imageai.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePublishPicToTextPart.N9(Function1.this, obj);
            }
        });
    }

    @Override // com.qzone.reborn.part.publish.mood.imageai.e.b
    public void F() {
        l lVar;
        l lVar2 = this.mPublishViewModel;
        l lVar3 = null;
        if (lVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishViewModel");
            lVar = null;
        } else {
            lVar = lVar2;
        }
        l lVar4 = this.mPublishViewModel;
        if (lVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishViewModel");
        } else {
            lVar3 = lVar4;
        }
        l.e2(lVar, lVar3.getCurrentImagePath(), Boolean.TRUE, null, 4, null);
    }

    @Override // cm.b.c
    public void F5(QZoneAutoTexting$TextInfo data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("QZonePublishPicToTextPart", 1, "[onItemClick] select dialog content:" + data.content.get());
        ExtendEditText extendEditText = this.publishActivity.f45104j0;
        String str = data.content.get();
        if (TextUtils.isEmpty(str) || extendEditText == null) {
            return;
        }
        com.qzone.reborn.configx.g gVar = com.qzone.reborn.configx.g.f53821a;
        if (gVar.b().g0() && !this.mIsAppendAiTextTail) {
            str = str + gVar.b().j1();
            this.mIsAppendAiTextTail = true;
        }
        am.g(str, extendEditText.getSelectionStart(), extendEditText);
        e eVar = this.mHalfScreenFloatDialog;
        if (eVar != null) {
            eVar.dismiss();
        }
        l lVar = this.mPublishViewModel;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishViewModel");
            lVar = null;
        }
        lVar.h2(data);
    }

    @Override // com.qzone.reborn.base.k, com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return super.isPartEnable() && f.b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f69313ie) {
            R9();
        } else if (valueOf != null && valueOf.intValue() == R.id.f69273ia) {
            Q9();
        } else if (valueOf != null && valueOf.intValue() == R.id.f29170kx) {
            S9();
        } else if (valueOf != null && valueOf.intValue() == R.id.f69323if) {
            P9();
        } else if (valueOf != null) {
            valueOf.intValue();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        O9(rootView);
        initViewModel();
        L9();
        X9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (this.mHalfScreenFloatDialog != null) {
            l lVar = this.mPublishViewModel;
            if (lVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPublishViewModel");
                lVar = null;
            }
            l.T1(lVar, null, 1, null);
        }
        e eVar = this.mHalfScreenFloatDialog;
        if (eVar != null) {
            eVar.dismiss();
        }
    }

    private final void O9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f29160kw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.publish_mood_menu_mask)");
        this.mPicToTextMaskView = findViewById;
        View findViewById2 = rootView.findViewById(R.id.f29170kx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ublish_pic_to_text_label)");
        this.mPicToTextLabel = (MoodPicLabel) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f69293ic);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026_to_text_guide_container)");
        this.mGuideContainerView = (FrameLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f69283ib);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026ish_pic_to_text_guide_bg)");
        this.mGuideBgView = (ImageView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f69303id);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026h_pic_to_text_left_guide)");
        this.mGuideLeftView = (TextView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f69313ie);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026h_pic_to_text_link_guide)");
        this.mGuideLinkView = (TextView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f69323if);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026h_pic_to_text_open_guide)");
        this.mGuideOpenView = (TextView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.f69273ia);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.\u2026_pic_to_text_close_guide)");
        this.mGuideCloseView = (ImageView) findViewById8;
        FrameLayout frameLayout = this.mGuideContainerView;
        View view = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideContainerView");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(this);
        MoodPicLabel moodPicLabel = this.mPicToTextLabel;
        if (moodPicLabel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicToTextLabel");
            moodPicLabel = null;
        }
        moodPicLabel.setOnClickListener(this);
        TextView textView = this.mGuideLinkView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideLinkView");
            textView = null;
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.mGuideOpenView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideOpenView");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        ImageView imageView = this.mGuideCloseView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideCloseView");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        View view2 = this.mPicToTextMaskView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicToTextMaskView");
            view2 = null;
        }
        view2.setVisibility(0);
        MoodPicLabel moodPicLabel2 = this.mPicToTextLabel;
        if (moodPicLabel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicToTextLabel");
            moodPicLabel2 = null;
        }
        moodPicLabel2.setVisibility(0);
        View view3 = this.mPicToTextMaskView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicToTextMaskView");
        } else {
            view = view3;
        }
        view.setBackground(getContext().getResources().getDrawable(QQTheme.isNowThemeIsNight() ? R.drawable.lfv : R.drawable.lfu));
    }

    static /* synthetic */ void U9(QZonePublishPicToTextPart qZonePublishPicToTextPart, View view, int i3, Integer num, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            num = null;
        }
        qZonePublishPicToTextPart.T9(view, i3, num);
    }
}
