package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quitagview.QUITagIcon;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.biz.qui.quitagview.QUITagViewConfig;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendGroupData;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0014J(\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010\u001c\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/t;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/av;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendGroupData;", "Lcom/tencent/guild/aio/util/ex/c;", "", "v", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "u", "onThemeChanged", "", NodeProps.ON_LONG_CLICK, NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "f", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "mAvatar", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mNick", "i", "mButton", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mBg", "Lcom/tencent/biz/qui/quitagview/QUITagView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qui/quitagview/QUITagView;", "memberCntTag", "D", "descTag", "E", "desc", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class t extends av<RecommendGroupData> implements com.tencent.guild.aio.util.ex.c {

    /* renamed from: C, reason: from kotlin metadata */
    private QUITagView memberCntTag;

    /* renamed from: D, reason: from kotlin metadata */
    private QUITagView descTag;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView desc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView mAvatar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mNick;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mBg;

    private final void v() {
        String str;
        com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
        ImageView imageView = this.mBg;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBg");
            imageView = null;
        }
        if (GuildThemeManager.f235286a.b()) {
            str = "https://downv6.qq.com/innovate/guild/sfeed/MVPRecommendGroupBackgroundDark_v2.png";
        } else {
            str = "https://downv6.qq.com/innovate/guild/sfeed/MVPRecommendGroupBackgroundOrigin_v2.png";
        }
        com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, imageView, str, 0, 0, false, 28, null);
        ImageView imageView2 = this.mBg;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBg");
            imageView2 = null;
        }
        ImageView imageView3 = this.mBg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBg");
            imageView3 = null;
        }
        imageView2.setBackground(ResourcesCompat.getDrawable(imageView3.getResources(), R.drawable.qui_common_fill_light_secondary_bg_corner_4, null));
        TextView textView = this.mButton;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mButton");
        } else {
            view = textView;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        ie0.a f16 = ie0.a.f();
        gradientDrawable.setColor(f16.g(this.mRootView.getContext(), R.color.qui_button_bg_secondary_default, 1000));
        gradientDrawable.setStroke(com.tencent.biz.qui.quicommon.e.a(0.5f), f16.g(this.mRootView.getContext(), R.color.qui_button_border_secondary_default, 1000));
        gradientDrawable.setCornerRadius(com.tencent.biz.qui.quicommon.e.a(4.0f));
        view.setBackground(gradientDrawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.d p16 = p();
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        p16.g((RecommendGroupData) mData, v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f165470w60);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026_v2_recommend_contact_bg)");
        this.mBg = (ImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.w5z);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026recommend_contact_avatar)");
        this.mAvatar = (QQProAvatarView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f165473w63);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u20262_recommend_contact_nick)");
        this.mNick = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f165472w62);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u20262_recommend_contact_join)");
        this.mButton = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.f165474w64);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u20262_recommend_contact_tag1)");
        this.memberCntTag = (QUITagView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.w65);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u20262_recommend_contact_tag2)");
        this.descTag = (QUITagView) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.wv8);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026_recommend_group_profile)");
        this.desc = (TextView) findViewById7;
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewExtKt.b(rootView, this);
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

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e0 A[EDGE_INSN: B:47:0x00e0->B:48:0x00e0 BREAK  A[LOOP:0: B:38:0x00c2->B:77:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[LOOP:0: B:38:0x00c2->B:77:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00df A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0089  */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindData(@NotNull RecommendGroupData data, int position, @Nullable List<Object> payload) {
        boolean z16;
        TextView textView;
        String groupSummary;
        boolean z17;
        QUITagView qUITagView;
        Iterator<T> it;
        Object obj;
        String str;
        TextView textView2;
        TextView textView3;
        String groupName;
        TextView textView4;
        String joinText;
        QQProAvatarView qQProAvatarView;
        QQProAvatarView qQProAvatarView2;
        boolean z18;
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(data, "data");
        v();
        QUITagView qUITagView2 = this.memberCntTag;
        if (qUITagView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberCntTag");
            qUITagView2 = null;
        }
        qUITagView2.setVisibility(8);
        String groupMembers = data.getGroupMembers();
        if (groupMembers != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(groupMembers);
            if (!isBlank2) {
                z16 = false;
                if (!(!z16)) {
                    groupMembers = null;
                }
                if (groupMembers != null) {
                    QUITagView qUITagView3 = this.memberCntTag;
                    if (qUITagView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("memberCntTag");
                        qUITagView3 = null;
                    }
                    qUITagView3.setVisibility(0);
                    QUITagView qUITagView4 = this.memberCntTag;
                    if (qUITagView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("memberCntTag");
                        qUITagView4 = null;
                    }
                    qUITagView4.setConfig(new QUITagViewConfig(QUITagType.FILL, QUITagSize.SMALL, new QUITagIcon(R.drawable.qui_user, null, false, 6, null), groupMembers));
                }
                textView = this.desc;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("desc");
                    textView = null;
                }
                textView.setVisibility(8);
                groupSummary = data.getGroupSummary();
                Intrinsics.checkNotNullExpressionValue(groupSummary, "data.groupSummary");
                if (groupSummary.length() <= 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    TextView textView5 = this.desc;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("desc");
                        textView5 = null;
                    }
                    textView5.setVisibility(0);
                    TextView textView6 = this.desc;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("desc");
                        textView6 = null;
                    }
                    textView6.setText(data.getGroupSummary());
                }
                qUITagView = this.descTag;
                if (qUITagView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("descTag");
                    qUITagView = null;
                }
                qUITagView.setVisibility(8);
                ArrayList<String> recommendReasons = data.getRecommendReasons();
                Intrinsics.checkNotNullExpressionValue(recommendReasons, "data.recommendReasons");
                it = recommendReasons.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = it.next();
                        String str2 = (String) obj;
                        if (str2 != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                            if (!isBlank) {
                                z18 = false;
                                if (!(!z18)) {
                                    break;
                                }
                            }
                        }
                        z18 = true;
                        if (!(!z18)) {
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                str = (String) obj;
                if (str == null) {
                    QUITagView qUITagView5 = this.descTag;
                    if (qUITagView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("descTag");
                        qUITagView5 = null;
                    }
                    qUITagView5.setVisibility(0);
                    QUITagView qUITagView6 = this.descTag;
                    if (qUITagView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("descTag");
                        qUITagView6 = null;
                    }
                    textView2 = null;
                    qUITagView6.setConfig(new QUITagViewConfig(QUITagType.FILL, QUITagSize.SMALL, null, str));
                } else {
                    textView2 = null;
                }
                textView3 = this.mNick;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNick");
                    textView3 = textView2;
                }
                groupName = data.getGroupName();
                if (groupName == null) {
                    groupName = "";
                }
                textView3.setText(groupName);
                textView4 = this.mButton;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mButton");
                    textView4 = textView2;
                }
                joinText = data.getJoinText();
                if (joinText == null) {
                    joinText = "\u52a0\u5165";
                }
                textView4.setText(joinText);
                qQProAvatarView = this.mAvatar;
                if (qQProAvatarView != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
                    qQProAvatarView2 = textView2;
                } else {
                    qQProAvatarView2 = qQProAvatarView;
                }
                qQProAvatarView2.w(4, String.valueOf(data.getGroupCode()));
            }
        }
        z16 = true;
        if (!(!z16)) {
        }
        if (groupMembers != null) {
        }
        textView = this.desc;
        if (textView == null) {
        }
        textView.setVisibility(8);
        groupSummary = data.getGroupSummary();
        Intrinsics.checkNotNullExpressionValue(groupSummary, "data.groupSummary");
        if (groupSummary.length() <= 0) {
        }
        if (z17) {
        }
        qUITagView = this.descTag;
        if (qUITagView == null) {
        }
        qUITagView.setVisibility(8);
        ArrayList<String> recommendReasons2 = data.getRecommendReasons();
        Intrinsics.checkNotNullExpressionValue(recommendReasons2, "data.recommendReasons");
        it = recommendReasons2.iterator();
        while (true) {
            if (!it.hasNext()) {
            }
        }
        str = (String) obj;
        if (str == null) {
        }
        textView3 = this.mNick;
        if (textView3 == null) {
        }
        groupName = data.getGroupName();
        if (groupName == null) {
        }
        textView3.setText(groupName);
        textView4 = this.mButton;
        if (textView4 == null) {
        }
        joinText = data.getJoinText();
        if (joinText == null) {
        }
        textView4.setText(joinText);
        qQProAvatarView = this.mAvatar;
        if (qQProAvatarView != null) {
        }
        qQProAvatarView2.w(4, String.valueOf(data.getGroupCode()));
    }
}
