package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.immersive.views.QFSBannerPointIndicator;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001=B\u000f\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0005R$\u0010+\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010.R\u0016\u00105\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010.R\u0016\u00107\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010.R\u0016\u00108\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010.\u00a8\u0006>"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSEDaxiaTipsDialog;", "Lcom/tencent/biz/qqcircle/widgets/QFSBaseBottomSheetDialog;", "Landroid/view/View$OnClickListener;", "", "initView", "Z", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "U", "X", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "W", "", "position", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "show", "v", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "topBg", UserInfo.SEX_FEMALE, "titleIcon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "titleTv", "H", "sendBtn", "", "I", "isEDaxia", "J", "Landroid/view/View;", "getParentView", "()Landroid/view/View;", "Y", "(Landroid/view/View;)V", "parentView", "", "K", "Ljava/lang/String;", "introPicUrl", "L", "rightsPicUrl", "M", "dutyPicUrl", "N", "textEDaxia", "P", "textNotEDaxia", "btnJumpUrl", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSEDaxiaTipsDialog extends QFSBaseBottomSheetDialog implements View.OnClickListener {

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView topBg;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView titleIcon;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView titleTv;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView sendBtn;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isEDaxia;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View parentView;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String introPicUrl;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String rightsPicUrl;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String dutyPicUrl;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private String textEDaxia;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private String textNotEDaxia;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private String btnJumpUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/widgets/QFSEDaxiaTipsDialog$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "state", "", "onPageScrollStateChanged", "position", "onPageSelected", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QFSImageBanner f93216b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QFSEDaxiaTipsDialog f93217c;

        b(QFSImageBanner qFSImageBanner, QFSEDaxiaTipsDialog qFSEDaxiaTipsDialog) {
            this.f93216b = qFSImageBanner;
            this.f93217c = qFSEDaxiaTipsDialog;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            if (state == 0) {
                VideoReport.traversePage(this.f93216b);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            this.f93217c.S(position);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSEDaxiaTipsDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.introPicUrl = "";
        this.rightsPicUrl = "";
        this.dutyPicUrl = "";
        this.textEDaxia = "";
        this.textNotEDaxia = "";
        this.btnJumpUrl = "https://m.xsj.qq.com/kuikly/jump?_wv=3&open_kuikly_info=%7B%22page_name%22%3A%22QVideoEDaXiaIndex%22%2C%22bundle_name%22%3A%22qq_video_e_da_xia_index%22%2C%22kr_turbo_display%22%3A1%2C%22kr_min_qq_version%22%3A%229.0.35%22%7D";
        initView();
    }

    private final void Q() {
        String str;
        TextView textView = this.sendBtn;
        if (textView == null) {
            return;
        }
        VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_QQ_HERO_POP);
        View view = this.parentView;
        if (view != null) {
            VideoReport.setLogicParent(this.sendBtn, view);
        }
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        if (this.isEDaxia) {
            str = QCircleDaTongConstant.ElementParamValue.XSJ_EDAXIA_ALREADY_JOINED;
        } else {
            str = QCircleDaTongConstant.ElementParamValue.XSJ_EDAXIA_NOT_JOINED;
        }
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_status", str);
        VideoReport.setElementParams(this.sendBtn, map);
        VideoReport.setElementClickPolicy(this.sendBtn, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(this.sendBtn, ExposurePolicy.REPORT_NONE);
    }

    private final void R() {
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), this.btnJumpUrl);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(int position) {
        String str;
        int i3;
        ImageView imageView = this.titleIcon;
        if (imageView != null) {
            if (position == 0) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
        if (position != 0) {
            if (position != 1) {
                str = "\u5de5\u4f5c\u804c\u8d23\u4e0e\u4e49\u52a1";
            } else {
                str = "\u6743\u76ca\u4e0e\u6fc0\u52b1";
            }
        } else {
            str = "\u662f\u4ec0\u4e48";
        }
        TextView textView = this.titleTv;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private final void U(View rootView) {
        String str;
        View findViewById = rootView.findViewById(R.id.f44151oe);
        View findViewById2 = rootView.findViewById(R.id.f44381p1);
        if (findViewById != null) {
            findViewById.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_shape_default_bg_top_r8));
        }
        if (findViewById2 != null) {
            findViewById2.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_shape_default_bg_top_r8));
        }
        View findViewById3 = rootView.findViewById(R.id.y4l);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026v_hot_topic_right_top_bg)");
        this.topBg = (ImageView) findViewById3;
        this.titleIcon = (ImageView) rootView.findViewById(R.id.f47931ym);
        if (QCircleSkinHelper.getInstance().isDarkMode()) {
            str = "https://qq-video.cdn-go.cn/android/latest/darkmode/edaxia/qvideo_skin_edaxia_popup_top.png";
        } else {
            str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/edaxia/qvideo_skin_edaxia_popup_top.png";
        }
        Option loadingDrawableColor = Option.obtain().setUrl(str).setRegionWidth(cx.a(201.0f)).setRegionHeight(cx.a(126.0f)).setLoadingDrawableColor(0);
        ImageView imageView = this.topBg;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBg");
            imageView = null;
        }
        Option targetView = loadingDrawableColor.setTargetView(imageView);
        targetView.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(targetView);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl("https://qq-video.cdn-go.cn/android/latest/defaultmode/edaxia/qvideo_edaxia_comment_tag_big.png").setRegionWidth(cx.a(100.0f)).setRegionHeight(cx.a(32.0f)).setLoadingDrawableColor(0).setTargetView(this.titleIcon));
    }

    private final void W(View rootView) {
        View findViewById = rootView.findViewById(R.id.f43991nz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qfs_image_banner)");
        QFSImageBanner qFSImageBanner = (QFSImageBanner) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f47041w8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ix_feed_banner_indicator)");
        QFSBannerPointIndicator qFSBannerPointIndicator = (QFSBannerPointIndicator) findViewById2;
        TextView textView = (TextView) rootView.findViewById(R.id.f55572i_);
        this.titleTv = textView;
        if (textView != null) {
            textView.setTextColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_text_primary));
        }
        qFSBannerPointIndicator.setCount(3);
        qFSBannerPointIndicator.b(qFSImageBanner.X());
        qFSImageBanner.q0(new b(qFSImageBanner, this));
        com.tencent.biz.qqcircle.immersive.adapter.b bVar = new com.tencent.biz.qqcircle.immersive.adapter.b();
        qFSImageBanner.setAdapter(bVar);
        qFSImageBanner.setEnableOperate(true);
        bVar.x0(this.introPicUrl);
        bVar.y0(this.rightsPicUrl);
        bVar.w0(this.dutyPicUrl);
        bVar.u0();
    }

    private final void X(View rootView) {
        ImageView imageView = (ImageView) rootView.findViewById(R.id.f41911ic);
        if (imageView != null) {
            imageView.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_icon_general_close_primary));
        }
        this.sendBtn = (TextView) rootView.findViewById(R.id.f3630147);
        boolean z16 = QCirclePluginGlobalInfo.m().is_e_da_xia.get();
        this.isEDaxia = z16;
        if (z16) {
            TextView textView = this.sendBtn;
            if (textView != null) {
                textView.setText(this.textEDaxia);
            }
        } else {
            TextView textView2 = this.sendBtn;
            if (textView2 != null) {
                textView2.setText(this.textNotEDaxia);
            }
        }
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        TextView textView3 = this.sendBtn;
        if (textView3 != null) {
            textView3.setOnClickListener(this);
        }
    }

    private final void Z() {
        HashMap hashMap = new HashMap();
        String str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/edaxia/qvideo_skin_edaxia_popup_jieshao.png";
        hashMap.put("pic_url_intro", "https://qq-video.cdn-go.cn/android/latest/defaultmode/edaxia/qvideo_skin_edaxia_popup_jieshao.png");
        String str2 = "https://qq-video.cdn-go.cn/android/latest/defaultmode/edaxia/qvideo_skin_edaxia_popup_quanyi.png";
        hashMap.put("pic_url_rights", "https://qq-video.cdn-go.cn/android/latest/defaultmode/edaxia/qvideo_skin_edaxia_popup_quanyi.png");
        String str3 = "https://qq-video.cdn-go.cn/android/latest/defaultmode/edaxia/qvideo_skin_edaxia_popup_zhize.png";
        hashMap.put("pic_url_duty", "https://qq-video.cdn-go.cn/android/latest/defaultmode/edaxia/qvideo_skin_edaxia_popup_zhize.png");
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1899640t);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_edaxi\u2026congratulation_join_tips)");
        hashMap.put("button_text_daxia", a16);
        String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1899840v);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qfs_edaxia_submit_btn_tips)");
        hashMap.put("button_text_not_daxia", a17);
        String str4 = "https://m.xsj.qq.com/kuikly/jump?_wv=3&open_kuikly_info=%7B%22page_name%22%3A%22QVideoEDaXiaIndex%22%2C%22bundle_name%22%3A%22qq_video_e_da_xia_index%22%2C%22kr_turbo_display%22%3A1%2C%22kr_min_qq_version%22%3A%229.0.35%22%7D";
        hashMap.put("button_jump_url", "https://m.xsj.qq.com/kuikly/jump?_wv=3&open_kuikly_info=%7B%22page_name%22%3A%22QVideoEDaXiaIndex%22%2C%22bundle_name%22%3A%22qq_video_e_da_xia_index%22%2C%22kr_turbo_display%22%3A1%2C%22kr_min_qq_version%22%3A%229.0.35%22%7D");
        Map<String, String> M = uq3.o.M("qqcircle_comment_daixa_guide_config", hashMap);
        String str5 = M.get("pic_url_intro");
        if (str5 != null) {
            str = str5;
        }
        this.introPicUrl = str;
        String str6 = M.get("pic_url_rights");
        if (str6 != null) {
            str2 = str6;
        }
        this.rightsPicUrl = str2;
        String str7 = M.get("pic_url_duty");
        if (str7 != null) {
            str3 = str7;
        }
        this.dutyPicUrl = str3;
        String str8 = M.get("button_text_daxia");
        if (str8 == null) {
            str8 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1899640t);
            Intrinsics.checkNotNullExpressionValue(str8, "qqStr(R.string.qfs_edaxi\u2026congratulation_join_tips)");
        }
        this.textEDaxia = str8;
        String str9 = M.get("button_text_not_daxia");
        if (str9 == null) {
            str9 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1899840v);
            Intrinsics.checkNotNullExpressionValue(str9, "qqStr(R.string.qfs_edaxia_submit_btn_tips)");
        }
        this.textNotEDaxia = str9;
        String str10 = M.get("button_jump_url");
        if (str10 != null) {
            str4 = str10;
        }
        this.btnJumpUrl = str4;
    }

    private final void initView() {
        Z();
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.g_u, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        U(rootView);
        X(rootView);
        W(rootView);
        setContentView(rootView);
    }

    public final void Y(@Nullable View view) {
        this.parentView = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f41911ic) {
            dismiss();
        } else if (num != null && num.intValue() == R.id.f3630147) {
            R();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.bottomsheet.a, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (bz.k()) {
            getBehavior().setState(3);
        }
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSBaseBottomSheetDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        Q();
        VideoReport.reportEvent("dt_imp", this.sendBtn, new QCircleDTParamBuilder().buildElementParams());
    }
}
