package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.biz.qui.quitagview.QUITagViewConfig;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildNewRecommendFragment;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.RecommendReportHelperKt;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendSelectedGuildData;
import com.tencent.mobileqq.guild.discoveryv2.content.util.UpdateRecommendGuildsData;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProOfficialMedalInfoExt;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard;
import com.tencent.mobileqq.qqguildsdk.data.genc.cy;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0011\n\u0002\b\b\u0018\u0000 ]2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001^B\u0007\u00a2\u0006\u0004\b[\u0010\\J\b\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J(\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J$\u0010!\u001a\u00020\u00062\u001a\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020$H\u0014J\u0012\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010(\u001a\u00020\u0006H\u0016J(\u0010/\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0014J\u0010\u00101\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u0013H\u0016J\u0010\u00102\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0013H\u0016J\u0012\u00104\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0005050\u001dH\u0016J\b\u00107\u001a\u00020\u0006H\u0016R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010>R\u0016\u0010C\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010>R\u0016\u0010D\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010>R\u0016\u0010F\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010ER\u0016\u0010H\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010J\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010ER\u0016\u0010L\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010KR\u0016\u0010M\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010KR\u0016\u0010O\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010KR\u0016\u0010R\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010QR\u0016\u0010V\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010QR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00130W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendFeaturedGuildsSection;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/av;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendSelectedGuildData;", "Lcom/tencent/guild/aio/util/ex/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "H", "Landroid/widget/TextView;", "textView", "", "guildName", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalList", HippyTKDListViewAdapter.X, "Lcom/tencent/image/URLDrawable;", "urlDrawable", "G", "Landroid/view/View;", "tagContainer", "Lcom/tencent/biz/qui/quitagview/QUITagView;", "tagView", "label", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/guild/discoveryv2/content/util/UpdateRecommendGuildsData;", "eventData", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSelectedGuildCard;", "Lkotlin/collections/ArrayList;", "guildsInfo", "y", "guildInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "getViewStubLayoutId", "containerView", "onInitView", "onThemeChanged", "data", "", "position", "", "", "payload", "D", "v", NodeProps.ON_LONG_CLICK, NodeProps.ON_CLICK, "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "f", "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "mBg", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mTitle", "i", "mAvatarTop", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mAvatarMid", "mAvatarBottom", "Landroid/widget/TextView;", "mNickTop", "E", "mNickMid", UserInfo.SEX_FEMALE, "mNickBottom", "Lcom/tencent/biz/qui/quitagview/QUITagView;", "mTagTop", "mTagMid", "I", "mTagBottom", "J", "Landroid/view/View;", "mTagTopContainer", "K", "mTagMidContainer", "L", "mTagBottomContainer", "", "M", "[Landroid/view/View;", "viewList", "<init>", "()V", "N", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendFeaturedGuildsSection extends av<RecommendSelectedGuildData> implements com.tencent.guild.aio.util.ex.c, SimpleEventReceiver<SimpleBaseEvent> {

    @NotNull
    private static ArrayList<cy> P = new ArrayList<>();
    private static final int Q = QQGuildUIUtil.f(22.0f);
    private static final int R = QQGuildUIUtil.f(12.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mAvatarBottom;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mNickTop;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mNickMid;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mNickBottom;

    /* renamed from: G, reason: from kotlin metadata */
    private QUITagView mTagTop;

    /* renamed from: H, reason: from kotlin metadata */
    private QUITagView mTagMid;

    /* renamed from: I, reason: from kotlin metadata */
    private QUITagView mTagBottom;

    /* renamed from: J, reason: from kotlin metadata */
    private View mTagTopContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private View mTagMidContainer;

    /* renamed from: L, reason: from kotlin metadata */
    private View mTagBottomContainer;

    /* renamed from: M, reason: from kotlin metadata */
    private View[] viewList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundImageView mBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mAvatarTop;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mAvatarMid;

    public RecommendFeaturedGuildsSection() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final boolean A(final TextView textView, final View tagContainer, final QUITagView tagView, final String label) {
        return textView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.k
            @Override // java.lang.Runnable
            public final void run() {
                RecommendFeaturedGuildsSection.B(textView, tagContainer, tagView, label);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(TextView textView, View tagContainer, QUITagView tagView, String label) {
        Intrinsics.checkNotNullParameter(textView, "$textView");
        Intrinsics.checkNotNullParameter(tagContainer, "$tagContainer");
        Intrinsics.checkNotNullParameter(tagView, "$tagView");
        Intrinsics.checkNotNullParameter(label, "$label");
        if (textView.getLineCount() > 1) {
            tagContainer.setVisibility(8);
            tagView.setVisibility(8);
        } else {
            tagContainer.setVisibility(0);
            tagView.setVisibility(0);
            tagView.setConfig(new QUITagViewConfig(QUITagType.FILL, QUITagSize.SMALL, null, label));
        }
    }

    private final void C(UpdateRecommendGuildsData eventData) {
        QLog.d("RecommendFeaturedGuildsSection", 1, "handleUpdateRecommendGuildsData");
        y(eventData.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(RecommendFeaturedGuildsSection this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        this$0.onClick(v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(URLDrawable urlDrawable, TextView textView, String guildName) {
        SpannableString spannableString = new SpannableString(guildName + "   ");
        spannableString.setSpan(new ImageSpan(urlDrawable, 1), guildName.length() + 1, guildName.length() + 2, 33);
        textView.setText(spannableString);
    }

    private final void H() {
        RoundImageView roundImageView;
        String str;
        ImageView imageView;
        String str2;
        com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
        RoundImageView roundImageView2 = this.mBg;
        if (roundImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBg");
            roundImageView = null;
        } else {
            roundImageView = roundImageView2;
        }
        GuildThemeManager guildThemeManager = GuildThemeManager.f235286a;
        if (guildThemeManager.b()) {
            str = "https://downv6.qq.com/innovate/guild/sfeed/guild_discover_selected_bg_dark.png";
        } else {
            str = "https://downv6.qq.com/innovate/guild/sfeed/guild_discover_selected_bg.png";
        }
        com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, roundImageView, str, 0, 0, false, 28, null);
        ImageView imageView2 = this.mTitle;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            imageView = null;
        } else {
            imageView = imageView2;
        }
        if (guildThemeManager.b()) {
            str2 = "https://downv6.qq.com/innovate/guild/sfeed/guild_discover_selected_title_dark.png";
        } else {
            str2 = "https://downv6.qq.com/innovate/guild/sfeed/guild_discover_selected_title.png";
        }
        com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, imageView, str2, 0, 0, false, 28, null);
    }

    private final void x(final TextView textView, final String guildName, List<? extends IGProMedalInfo> medalList) {
        CharSequence trim;
        String a16 = com.tencent.mobileqq.guild.util.az.a(guildName);
        Intrinsics.checkNotNullExpressionValue(a16, "changeEnterToSpace(guildName)");
        trim = StringsKt__StringsKt.trim((CharSequence) a16);
        String obj = trim.toString();
        Object obj2 = null;
        if (medalList != null) {
            Iterator<T> it = medalList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                IGProOfficialMedalInfoExt officialMedalInfoExt = ((IGProMedalInfo) next).getOfficialMedalInfoExt();
                boolean z16 = false;
                if (officialMedalInfoExt != null && officialMedalInfoExt.getIsOffical()) {
                    z16 = true;
                }
                if (z16) {
                    obj2 = next;
                    break;
                }
            }
            obj2 = (IGProMedalInfo) obj2;
        }
        textView.setText(obj);
        if (obj2 != null) {
            com.tencent.mobileqq.guild.util.an.INSTANCE.e(new WeakReference<>(textView), new Function2<URLDrawable, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendFeaturedGuildsSection$bindNameAndMedal$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(URLDrawable uRLDrawable, Integer num) {
                    invoke(uRLDrawable, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull URLDrawable urlDrawable, int i3) {
                    Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                    RecommendFeaturedGuildsSection.this.G(urlDrawable, textView, guildName);
                }
            }, R);
        }
    }

    private final void y(ArrayList<IGProSelectedGuildCard> guildsInfo) {
        ImageView imageView;
        Object orNull;
        Object orNull2;
        ImageView imageView2;
        Object obj;
        boolean z16;
        ImageView imageView3;
        Object obj2;
        boolean z17;
        Object obj3;
        boolean z18;
        P.clear();
        if (guildsInfo != null) {
            com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
            ImageView imageView4 = this.mAvatarTop;
            QUITagView qUITagView = null;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarTop");
                imageView = null;
            } else {
                imageView = imageView4;
            }
            com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, imageView, guildsInfo.get(0).getGuildAvatar(), 0, 0, false, 28, null);
            TextView textView = this.mNickTop;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNickTop");
                textView = null;
            }
            String guildName = guildsInfo.get(0).getGuildName();
            Intrinsics.checkNotNullExpressionValue(guildName, "guildsInfo[0].guildName");
            x(textView, guildName, guildsInfo.get(0).getMedals());
            IGProSelectedGuildCard iGProSelectedGuildCard = guildsInfo.get(0);
            Intrinsics.checkNotNullExpressionValue(iGProSelectedGuildCard, "guildsInfo[0]");
            z(iGProSelectedGuildCard);
            View view = this.mTagTopContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTagTopContainer");
                view = null;
            }
            view.setVisibility(8);
            if (guildsInfo.get(0).getGuildName().length() < Integer.MAX_VALUE) {
                ArrayList<IGProGuildLabel> tagList = guildsInfo.get(0).getTagList();
                Intrinsics.checkNotNullExpressionValue(tagList, "guildsInfo[0].tagList");
                Iterator<T> it = tagList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj3 = it.next();
                        byte[] labelName = ((IGProGuildLabel) obj3).getLabelName();
                        Intrinsics.checkNotNullExpressionValue(labelName, "it.labelName");
                        if (labelName.length == 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (!z18) {
                            break;
                        }
                    } else {
                        obj3 = null;
                        break;
                    }
                }
                IGProGuildLabel iGProGuildLabel = (IGProGuildLabel) obj3;
                if (iGProGuildLabel != null) {
                    TextView textView2 = this.mNickTop;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mNickTop");
                        textView2 = null;
                    }
                    View view2 = this.mTagTopContainer;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTagTopContainer");
                        view2 = null;
                    }
                    QUITagView qUITagView2 = this.mTagTop;
                    if (qUITagView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTagTop");
                        qUITagView2 = null;
                    }
                    byte[] labelName2 = iGProGuildLabel.getLabelName();
                    Intrinsics.checkNotNullExpressionValue(labelName2, "it.labelName");
                    A(textView2, view2, qUITagView2, new String(labelName2, Charsets.UTF_8));
                }
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(guildsInfo, 1);
            if (((IGProSelectedGuildCard) orNull) != null) {
                com.tencent.mobileqq.guild.discoveryv2.util.d dVar2 = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
                ImageView imageView5 = this.mAvatarMid;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAvatarMid");
                    imageView3 = null;
                } else {
                    imageView3 = imageView5;
                }
                com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar2, imageView3, guildsInfo.get(1).getGuildAvatar(), 0, 0, false, 28, null);
                TextView textView3 = this.mNickMid;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNickMid");
                    textView3 = null;
                }
                String guildName2 = guildsInfo.get(1).getGuildName();
                Intrinsics.checkNotNullExpressionValue(guildName2, "guildsInfo[1].guildName");
                x(textView3, guildName2, guildsInfo.get(1).getMedals());
                IGProSelectedGuildCard iGProSelectedGuildCard2 = guildsInfo.get(1);
                Intrinsics.checkNotNullExpressionValue(iGProSelectedGuildCard2, "guildsInfo[1]");
                z(iGProSelectedGuildCard2);
                View view3 = this.mTagMidContainer;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTagMidContainer");
                    view3 = null;
                }
                view3.setVisibility(8);
                if (guildsInfo.get(1).getGuildName().length() < Integer.MAX_VALUE) {
                    ArrayList<IGProGuildLabel> tagList2 = guildsInfo.get(1).getTagList();
                    Intrinsics.checkNotNullExpressionValue(tagList2, "guildsInfo[1].tagList");
                    Iterator<T> it5 = tagList2.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            obj2 = it5.next();
                            byte[] labelName3 = ((IGProGuildLabel) obj2).getLabelName();
                            Intrinsics.checkNotNullExpressionValue(labelName3, "it.labelName");
                            if (labelName3.length == 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (!z17) {
                                break;
                            }
                        } else {
                            obj2 = null;
                            break;
                        }
                    }
                    IGProGuildLabel iGProGuildLabel2 = (IGProGuildLabel) obj2;
                    if (iGProGuildLabel2 != null) {
                        TextView textView4 = this.mNickMid;
                        if (textView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mNickMid");
                            textView4 = null;
                        }
                        View view4 = this.mTagMidContainer;
                        if (view4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTagMidContainer");
                            view4 = null;
                        }
                        QUITagView qUITagView3 = this.mTagMid;
                        if (qUITagView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTagMid");
                            qUITagView3 = null;
                        }
                        byte[] labelName4 = iGProGuildLabel2.getLabelName();
                        Intrinsics.checkNotNullExpressionValue(labelName4, "it.labelName");
                        A(textView4, view4, qUITagView3, new String(labelName4, Charsets.UTF_8));
                    }
                }
            }
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(guildsInfo, 2);
            if (((IGProSelectedGuildCard) orNull2) != null) {
                com.tencent.mobileqq.guild.discoveryv2.util.d dVar3 = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
                ImageView imageView6 = this.mAvatarBottom;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAvatarBottom");
                    imageView2 = null;
                } else {
                    imageView2 = imageView6;
                }
                com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar3, imageView2, guildsInfo.get(2).getGuildAvatar(), 0, 0, false, 28, null);
                TextView textView5 = this.mNickBottom;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNickBottom");
                    textView5 = null;
                }
                String guildName3 = guildsInfo.get(2).getGuildName();
                Intrinsics.checkNotNullExpressionValue(guildName3, "guildsInfo[2].guildName");
                x(textView5, guildName3, guildsInfo.get(2).getMedals());
                IGProSelectedGuildCard iGProSelectedGuildCard3 = guildsInfo.get(2);
                Intrinsics.checkNotNullExpressionValue(iGProSelectedGuildCard3, "guildsInfo[2]");
                z(iGProSelectedGuildCard3);
                View view5 = this.mTagBottomContainer;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTagBottomContainer");
                    view5 = null;
                }
                view5.setVisibility(8);
                if (guildsInfo.get(2).getGuildName().length() < Integer.MAX_VALUE) {
                    ArrayList<IGProGuildLabel> tagList3 = guildsInfo.get(2).getTagList();
                    Intrinsics.checkNotNullExpressionValue(tagList3, "guildsInfo[2].tagList");
                    Iterator<T> it6 = tagList3.iterator();
                    while (true) {
                        if (it6.hasNext()) {
                            obj = it6.next();
                            byte[] labelName5 = ((IGProGuildLabel) obj).getLabelName();
                            Intrinsics.checkNotNullExpressionValue(labelName5, "it.labelName");
                            if (labelName5.length == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (!z16) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    IGProGuildLabel iGProGuildLabel3 = (IGProGuildLabel) obj;
                    if (iGProGuildLabel3 != null) {
                        TextView textView6 = this.mNickBottom;
                        if (textView6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mNickBottom");
                            textView6 = null;
                        }
                        View view6 = this.mTagBottomContainer;
                        if (view6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTagBottomContainer");
                            view6 = null;
                        }
                        QUITagView qUITagView4 = this.mTagBottom;
                        if (qUITagView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTagBottom");
                        } else {
                            qUITagView = qUITagView4;
                        }
                        byte[] labelName6 = iGProGuildLabel3.getLabelName();
                        Intrinsics.checkNotNullExpressionValue(labelName6, "it.labelName");
                        A(textView6, view6, qUITagView, new String(labelName6, Charsets.UTF_8));
                    }
                }
            }
        }
    }

    private final void z(IGProSelectedGuildCard guildInfo) {
        cy cyVar = new cy();
        cyVar.h(guildInfo.getGuildId());
        cyVar.i(0L);
        cyVar.j(String.valueOf(guildInfo.getGuildId()));
        cyVar.g(0L);
        cyVar.k(8);
        cyVar.l("");
        P.add(cyVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull RecommendSelectedGuildData data, int position, @Nullable List<Object> payload) {
        Object orNull;
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d("RecommendFeaturedGuildsSection", 1, "RecommendSelectedGuildData data.selectedGuilds: " + data.getSelectedGuilds());
        H();
        ArrayList<IGProSelectedGuildCard> selectedGuilds = data.getSelectedGuilds();
        if (selectedGuilds != null) {
            y(selectedGuilds);
        }
        ArrayList<IGProSelectedGuildCard> selectedGuilds2 = data.getSelectedGuilds();
        Intrinsics.checkNotNullExpressionValue(selectedGuilds2, "data.selectedGuilds");
        int i3 = 0;
        for (Object obj : selectedGuilds2) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            IGProSelectedGuildCard iGProSelectedGuildCard = (IGProSelectedGuildCard) obj;
            View[] viewArr = this.viewList;
            Long l3 = null;
            if (viewArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewList");
                viewArr = null;
            }
            orNull = ArraysKt___ArraysKt.getOrNull(viewArr, i3);
            View view = (View) orNull;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        RecommendFeaturedGuildsSection.F(RecommendFeaturedGuildsSection.this, view2);
                    }
                });
                com.tencent.mobileqq.guild.discoveryv2.util.b bVar = com.tencent.mobileqq.guild.discoveryv2.util.b.f217789a;
                ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
                ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
                long itemId = data.getItemId();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(itemId);
                sb5.append(i3);
                String sb6 = sb5.toString();
                Map<String, Object> v3 = RecommendReportHelperKt.v(data, position - q().d());
                if (iGProSelectedGuildCard != null) {
                    l3 = Long.valueOf(iGProSelectedGuildCard.getGuildId());
                }
                v3.put("sgrp_channel_id", String.valueOf(l3));
                v3.put("sgrp_module_place", Integer.valueOf(i3));
                com.tencent.mobileqq.guild.discoveryv2.util.b.b(view, "em_sgrp_featured_channel_module_list", sb6, clickPolicy, exposurePolicy, null, v3, null, null, 416, null);
            }
            i3 = i16;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(UpdateRecommendGuildsData.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        GuildNewRecommendFragment.Companion companion = GuildNewRecommendFragment.INSTANCE;
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        companion.d(context, 0, "", 4, new GuildAppReportSourceInfo(), P);
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.av, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.w6p);
            Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026y_v2_recommend_guilds_bg)");
            this.mBg = (RoundImageView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.w6q);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u20262_recommend_guilds_title)");
            this.mTitle = (ImageView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.w6d);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026_recommend_guild_avatar1)");
            this.mAvatarTop = (ImageView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.w6e);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026_recommend_guild_avatar2)");
            this.mAvatarMid = (ImageView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.w6f);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026_recommend_guild_avatar3)");
            this.mAvatarBottom = (ImageView) findViewById5;
            View findViewById6 = containerView.findViewById(R.id.w4_);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026v2_recommend_guild_nick1)");
            this.mNickTop = (TextView) findViewById6;
            View findViewById7 = containerView.findViewById(R.id.w4a);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026v2_recommend_guild_nick2)");
            this.mNickMid = (TextView) findViewById7;
            View findViewById8 = containerView.findViewById(R.id.w4b);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewBy\u2026v2_recommend_guild_nick3)");
            this.mNickBottom = (TextView) findViewById8;
            View findViewById9 = containerView.findViewById(R.id.w6m);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "containerView.findViewBy\u2026_v2_recommend_guild_tag1)");
            this.mTagTop = (QUITagView) findViewById9;
            View findViewById10 = containerView.findViewById(R.id.w6n);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "containerView.findViewBy\u2026_v2_recommend_guild_tag2)");
            this.mTagMid = (QUITagView) findViewById10;
            View findViewById11 = containerView.findViewById(R.id.w6o);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "containerView.findViewBy\u2026_v2_recommend_guild_tag3)");
            this.mTagBottom = (QUITagView) findViewById11;
            View findViewById12 = containerView.findViewById(R.id.f919756m);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "containerView.findViewById(R.id.tag1)");
            this.mTagTopContainer = findViewById12;
            View findViewById13 = containerView.findViewById(R.id.f919856n);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "containerView.findViewById(R.id.tag2)");
            this.mTagMidContainer = findViewById13;
            View findViewById14 = containerView.findViewById(R.id.f919956o);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "containerView.findViewById(R.id.tag3)");
            this.mTagBottomContainer = findViewById14;
            View findViewById15 = containerView.findViewById(R.id.vvx);
            Intrinsics.checkNotNullExpressionValue(findViewById15, "containerView.findViewById(R.id.guild1)");
            View findViewById16 = containerView.findViewById(R.id.vvy);
            Intrinsics.checkNotNullExpressionValue(findViewById16, "containerView.findViewById(R.id.guild2)");
            View findViewById17 = containerView.findViewById(R.id.vvz);
            Intrinsics.checkNotNullExpressionValue(findViewById17, "containerView.findViewById(R.id.guild3)");
            this.viewList = new View[]{findViewById15, findViewById16, findViewById17};
            View rootView = getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            ViewExtKt.b(rootView, this);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.d p16 = p();
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        boolean i3 = p16.i((com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l) mData, v3, this.mPosition);
        EventCollector.getInstance().onViewLongClicked(v3);
        return i3;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof UpdateRecommendGuildsData) {
            C((UpdateRecommendGuildsData) event);
        }
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        H();
    }
}
