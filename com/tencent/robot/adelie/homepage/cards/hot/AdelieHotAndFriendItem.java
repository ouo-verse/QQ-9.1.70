package com.tencent.robot.adelie.homepage.cards.hot;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.urldrawable.b;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardInfoType;
import com.tencent.robot.adelie.homepage.cards.hot.AdelieHotAndFriendItem;
import com.tencent.robot.adelie.homepage.category.section.AdelieHomeCardHotView;
import com.tencent.robot.adelie.homepage.utils.AIOUtil;
import com.tencent.robot.qqmc.RobotQQMC;
import com.tencent.util.URLUtil;
import ie0.a;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import o14.AdelieHotAndFriendItemData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00101\u001a\u00020\u0006\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0006H\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001bR\u0018\u0010#\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0018\u0010%\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u001b\u00a8\u00064"}, d2 = {"Lcom/tencent/robot/adelie/homepage/cards/hot/AdelieHotAndFriendItem;", "Landroid/widget/RelativeLayout;", "Lo14/h;", "itemData", "", "e", "", "position", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardInfoType;", "type", "f", "", "", "d", "c", "", "isLast", "setPageMarginRight", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "hotImageView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "sortView", "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "userIcon", h.F, "nameTextView", "i", "hotNumberTextView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tagTextView", BdhLogUtil.LogTag.Tag_Conn, "Lo14/h;", "D", "Landroid/widget/RelativeLayout;", "hotBar", "E", "descView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieHotAndFriendItem extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private AdelieHotAndFriendItemData itemData;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout hotBar;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView descView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView hotImageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView sortView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundImageView userIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView nameTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView hotNumberTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tagTextView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieHotAndFriendItem(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdelieHotAndFriendItem this$0, Context context, View view) {
        RobotCoreInfo data;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        AdelieHotAndFriendItemData adelieHotAndFriendItemData = this$0.itemData;
        if (adelieHotAndFriendItemData != null && (data = adelieHotAndFriendItemData.getData()) != null) {
            AIOUtil.e(AIOUtil.f366629a, context, data, null, null, 12, null);
            VideoReport.reportEvent("clck", this$0, this$0.d());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Map<String, String> d() {
        String str;
        long j3;
        Map<String, String> mapOf;
        RobotCoreInfo data;
        Pair[] pairArr = new Pair[4];
        AdelieHotAndFriendItemData adelieHotAndFriendItemData = this.itemData;
        if (adelieHotAndFriendItemData == null || (str = adelieHotAndFriendItemData.getTabName()) == null) {
            str = "";
        }
        int i3 = 0;
        pairArr[0] = TuplesKt.to("tab_name", str);
        pairArr[1] = TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, "em_bas_top_recommendation_card");
        AdelieHotAndFriendItemData adelieHotAndFriendItemData2 = this.itemData;
        if (adelieHotAndFriendItemData2 != null && (data = adelieHotAndFriendItemData2.getData()) != null) {
            j3 = data.robotUin;
        } else {
            j3 = 0;
        }
        pairArr[2] = TuplesKt.to("agent_uin", String.valueOf(j3));
        AdelieHotAndFriendItemData adelieHotAndFriendItemData3 = this.itemData;
        if (adelieHotAndFriendItemData3 != null) {
            i3 = adelieHotAndFriendItemData3.getSerialNumber();
        }
        pairArr[3] = TuplesKt.to("serial_number", String.valueOf(i3 + 1));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final void e(AdelieHotAndFriendItemData itemData) {
        String format;
        TextView textView = this.hotNumberTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        RobotCoreInfo data = itemData.getData();
        if (data != null) {
            TextView textView2 = this.hotNumberTextView;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (itemData.getType() == RobotRecommendCardInfoType.KWEEKHOT) {
                TextView textView3 = this.hotNumberTextView;
                if (textView3 != null) {
                    textView3.setText(AdelieHomeCardHotView.INSTANCE.a(data.hotNumber));
                    return;
                }
                return;
            }
            long j3 = data.friendUV;
            if (j3 <= AppConstants.LBS_HELLO_UIN_LONGVALUE) {
                format = String.valueOf(j3);
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                format = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(j3 / 10000.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            TextView textView4 = this.hotNumberTextView;
            if (textView4 != null) {
                textView4.setText(format + " \u4e2a\u597d\u53cb\u5728\u73a9");
            }
        }
    }

    private final void f(RobotRecommendCardInfoType type) {
        Drawable o16;
        if (type == RobotRecommendCardInfoType.KFRIEDNHOT) {
            o16 = a.f().o(getContext(), R.drawable.qui_user, R.color.qui_common_icon_tertiary, 1000);
        } else {
            o16 = a.f().o(getContext(), R.drawable.qui_operation, R.color.qui_common_icon_tertiary, 1000);
        }
        ImageView imageView = this.hotImageView;
        if (imageView != null) {
            imageView.setImageDrawable(o16);
        }
    }

    private final void g(int position) {
        TextView textView;
        TextView textView2 = this.sortView;
        if (textView2 != null) {
            textView2.setText(String.valueOf(position));
        }
        TextView textView3 = this.sortView;
        if (textView3 != null) {
            textView3.setTextColor(getContext().getColor(R.color.qui_common_text_secondary));
        }
        if (position != 1) {
            if (position != 2) {
                if (position == 3 && (textView = this.sortView) != null) {
                    textView.setTextColor(Color.parseColor("#FFB300"));
                    return;
                }
                return;
            }
            TextView textView4 = this.sortView;
            if (textView4 != null) {
                textView4.setTextColor(Color.parseColor("#FF8B49"));
                return;
            }
            return;
        }
        TextView textView5 = this.sortView;
        if (textView5 != null) {
            textView5.setTextColor(Color.parseColor("#F74C30"));
        }
    }

    public final void c(@Nullable AdelieHotAndFriendItemData itemData) {
        String str;
        String str2;
        int i3;
        String str3;
        this.itemData = itemData;
        VideoReport.setElementId(this, "em_bas_bot_entry");
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_NONE);
        if (itemData != null) {
            TextView textView = this.nameTextView;
            String str4 = "";
            if (textView != null) {
                RobotCoreInfo data = itemData.getData();
                if (data == null || (str3 = data.name) == null) {
                    str3 = "";
                }
                textView.setText(str3);
            }
            TextView textView2 = this.tagTextView;
            if (textView2 != null) {
                if (itemData.getType() == RobotRecommendCardInfoType.KFRIEDNHOT) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                textView2.setVisibility(i3);
            }
            TextView textView3 = this.tagTextView;
            if (textView3 != null) {
                RobotCoreInfo data2 = itemData.getData();
                if (data2 == null || (str2 = data2.robotTag) == null) {
                    str2 = "";
                }
                textView3.setText(str2);
            }
            TextView textView4 = this.descView;
            if (textView4 != null) {
                RobotCoreInfo data3 = itemData.getData();
                if (data3 != null && (str = data3.desc) != null) {
                    str4 = str;
                }
                textView4.setText(str4);
            }
            f(itemData.getType());
            g(itemData.getSerialNumber() + 1);
            e(itemData);
            RobotCoreInfo data4 = itemData.getData();
            if (data4 != null) {
                String str5 = data4.robotAvatar;
                if (!RobotQQMC.INSTANCE.enableQQPicLoader()) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    Drawable drawable = b.f306350a;
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    if (URLUtil.isValidUrl(str5)) {
                        drawable = URLDrawable.getDrawable(data4.robotAvatar, obtain);
                    }
                    RoundImageView roundImageView = this.userIcon;
                    if (roundImageView != null) {
                        roundImageView.setImageDrawable(drawable);
                        return;
                    }
                    return;
                }
                RoundImageView roundImageView2 = this.userIcon;
                if (roundImageView2 != null && URLUtil.isValidUrl(str5)) {
                    Option url = Option.obtain().setTargetView(roundImageView2).setUrl(str5);
                    Drawable drawable2 = b.f306350a;
                    Option option = url.setLoadingDrawable(drawable2).setFailDrawable(drawable2);
                    QQPicLoader qQPicLoader = QQPicLoader.f201806a;
                    Intrinsics.checkNotNullExpressionValue(option, "option");
                    qQPicLoader.e(option, null);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            VideoReport.reportEvent("imp", this, d());
        }
    }

    public final void setPageMarginRight(boolean isLast) {
        RelativeLayout.LayoutParams layoutParams;
        ViewUtils viewUtils;
        float f16;
        RelativeLayout relativeLayout = this.hotBar;
        if (relativeLayout != null) {
            ViewGroup.LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                if (isLast) {
                    viewUtils = ViewUtils.f352270a;
                    f16 = 12.0f;
                } else {
                    viewUtils = ViewUtils.f352270a;
                    f16 = 40.0f;
                }
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, viewUtils.a(f16), layoutParams.bottomMargin);
                relativeLayout.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieHotAndFriendItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieHotAndFriendItem(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieHotAndFriendItem(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.dsr, this);
        this.hotImageView = (ImageView) findViewById(R.id.xbb);
        this.sortView = (TextView) findViewById(R.id.f86874su);
        this.userIcon = (RoundImageView) findViewById(R.id.klf);
        this.nameTextView = (TextView) findViewById(R.id.f5e);
        this.hotNumberTextView = (TextView) findViewById(R.id.xbc);
        this.tagTextView = (TextView) findViewById(R.id.xbj);
        this.hotBar = (RelativeLayout) findViewById(R.id.xb6);
        this.descView = (TextView) findViewById(R.id.bg6);
        getRootView().setOnClickListener(new View.OnClickListener() { // from class: o14.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdelieHotAndFriendItem.b(AdelieHotAndFriendItem.this, context, view);
            }
        });
    }
}
