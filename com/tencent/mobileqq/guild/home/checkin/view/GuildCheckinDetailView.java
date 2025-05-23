package com.tencent.mobileqq.guild.home.checkin.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildCheckinRsp;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;
import tl.h;
import vo1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 62\u00020\u00012\u00020\u0002:\u0001\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b,\u0010-B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\b,\u00100B#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b,\u00103B+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00104\u001a\u000201\u00a2\u0006\u0004\b,\u00105J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010\u001bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/home/checkin/view/GuildCheckinDetailView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "", "a", "Lvo1/b;", "checkinDetailCallback", "setCheckinCallback", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildCheckinRsp;", "checkinRsp", "", "forceShowActive", "setCheckinInfo", "", "guildId", QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "d", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "topTips", "f", "bottomTips", h.F, "tomorrowActiveTips", "Lcom/tencent/mobileqq/guild/home/checkin/view/GuildCheckinDayView;", "i", "Lcom/tencent/mobileqq/guild/home/checkin/view/GuildCheckinDayView;", "checkinDayView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "myActiveContainer", BdhLogUtil.LogTag.Tag_Conn, "openNotifyTips", "D", "Lvo1/b;", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "E", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildCheckinDetailView extends FrameLayout implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView openNotifyTips;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private b checkinDetailCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildUserAvatarView avatarView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView topTips;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView bottomTips;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tomorrowActiveTips;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildCheckinDayView checkinDayView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View myActiveContainer;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildCheckinDetailView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.ej5, this);
        View findViewById = findViewById(R.id.f164552t20);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatar_view)");
        this.avatarView = (GuildUserAvatarView) findViewById;
        View findViewById2 = findViewById(R.id.f100045rf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.top_tips)");
        this.topTips = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f164641tb4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.bottom_tips)");
        this.bottomTips = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f99385pn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tomorrow_active_tips)");
        this.tomorrowActiveTips = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f164794tw0);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.checkin_day_view)");
        this.checkinDayView = (GuildCheckinDayView) findViewById5;
        View findViewById6 = findViewById(R.id.zll);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.my_active_container)");
        this.myActiveContainer = findViewById6;
        View findViewById7 = findViewById(R.id.f166466zz2);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.open_notify_tips)");
        this.openNotifyTips = (TextView) findViewById7;
        View view = this.myActiveContainer;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myActiveContainer");
            view = null;
        }
        view.setOnClickListener(this);
        TextView textView2 = this.openNotifyTips;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("openNotifyTips");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(this);
    }

    public static /* synthetic */ void setCheckinInfo$default(GuildCheckinDetailView guildCheckinDetailView, IGProGuildCheckinRsp iGProGuildCheckinRsp, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        guildCheckinDetailView.setCheckinInfo(iGProGuildCheckinRsp, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        b bVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        View view = this.myActiveContainer;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myActiveContainer");
            view = null;
        }
        if (Intrinsics.areEqual(v3, view)) {
            b bVar2 = this.checkinDetailCallback;
            if (bVar2 != null) {
                bVar2.b(v3);
            }
        } else {
            TextView textView2 = this.openNotifyTips;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("openNotifyTips");
            } else {
                textView = textView2;
            }
            if (Intrinsics.areEqual(v3, textView) && (bVar = this.checkinDetailCallback) != null) {
                bVar.a(v3);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setAvatar(@NotNull String guildId) {
        String str;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        GuildUserAvatarView guildUserAvatarView = null;
        if (at.c()) {
            str = ((IGPSService) bz.b(IGPSService.class)).getSelfTinyId();
        } else {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("setAvatar session not ready");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildCheckinDetailCardView", 1, (String) it.next(), null);
            }
            str = "";
        }
        GuildUserAvatarView guildUserAvatarView2 = this.avatarView;
        if (guildUserAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            guildUserAvatarView2 = null;
        }
        guildUserAvatarView2.setAvatarTinyId(guildId, str);
        GuildUserAvatarView guildUserAvatarView3 = this.avatarView;
        if (guildUserAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        } else {
            guildUserAvatarView = guildUserAvatarView3;
        }
        guildUserAvatarView.setLogTag("GuildCheckinDetailCardView");
    }

    public final void setCheckinCallback(@NotNull b checkinDetailCallback) {
        Intrinsics.checkNotNullParameter(checkinDetailCallback, "checkinDetailCallback");
        this.checkinDetailCallback = checkinDetailCallback;
    }

    public final void setCheckinInfo(@NotNull IGProGuildCheckinRsp checkinRsp, boolean forceShowActive) {
        Intrinsics.checkNotNullParameter(checkinRsp, "checkinRsp");
        TextView textView = this.topTips;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTips");
            textView = null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        TextView textView3 = this.topTips;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTips");
            textView3 = null;
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(textView3.getResources().getColor(R.color.qui_common_text_primary));
        int length = spannableStringBuilder.length();
        if (checkinRsp.getCheckinCnt() == 1) {
            spannableStringBuilder.append((CharSequence) "\u5df2\u7b7e\u5230 ");
        } else {
            spannableStringBuilder.append((CharSequence) "\u5df2\u8fde\u7eed\u7b7e\u5230 ");
        }
        spannableStringBuilder.setSpan(foregroundColorSpan, length, spannableStringBuilder.length(), 17);
        TextView textView4 = this.topTips;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTips");
            textView4 = null;
        }
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(textView4.getResources().getColor(R.color.qui_common_text_link));
        int length2 = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) String.valueOf(checkinRsp.getCheckinCnt()));
        spannableStringBuilder.setSpan(foregroundColorSpan2, length2, spannableStringBuilder.length(), 17);
        TextView textView5 = this.topTips;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTips");
            textView5 = null;
        }
        ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(textView5.getResources().getColor(R.color.qui_common_text_primary));
        int length3 = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) " \u5929");
        spannableStringBuilder.setSpan(foregroundColorSpan3, length3, spannableStringBuilder.length(), 17);
        textView.setText(new SpannedString(spannableStringBuilder));
        TextView textView6 = this.bottomTips;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTips");
            textView6 = null;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        TextView textView7 = this.topTips;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTips");
            textView7 = null;
        }
        ForegroundColorSpan foregroundColorSpan4 = new ForegroundColorSpan(textView7.getResources().getColor(R.color.qui_common_text_primary));
        int length4 = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) "\u4eca\u65e5\u7b2c ");
        StyleSpan styleSpan = new StyleSpan(1);
        int length5 = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) String.valueOf(checkinRsp.getRank()));
        spannableStringBuilder2.setSpan(styleSpan, length5, spannableStringBuilder2.length(), 17);
        spannableStringBuilder2.append((CharSequence) " \u540d\u7b7e\u5230\u6210\u5458\uff0c\u6d3b\u8dc3\u503c");
        StyleSpan styleSpan2 = new StyleSpan(1);
        int length6 = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) (Marker.ANY_NON_NULL_MARKER + checkinRsp.getTodayActive()));
        spannableStringBuilder2.setSpan(styleSpan2, length6, spannableStringBuilder2.length(), 17);
        spannableStringBuilder2.setSpan(foregroundColorSpan4, length4, spannableStringBuilder2.length(), 17);
        textView6.setText(new SpannedString(spannableStringBuilder2));
        TextView textView8 = this.tomorrowActiveTips;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tomorrowActiveTips");
            textView8 = null;
        }
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
        TextView textView9 = this.topTips;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTips");
            textView9 = null;
        }
        ForegroundColorSpan foregroundColorSpan5 = new ForegroundColorSpan(textView9.getResources().getColor(R.color.qui_common_text_primary));
        int length7 = spannableStringBuilder3.length();
        spannableStringBuilder3.append((CharSequence) ("\u660e\u65e5\u7b7e\u5230\u53ef\u5f97\u6d3b\u8dc3\u503c+" + checkinRsp.getTomorrowActive()));
        spannableStringBuilder3.setSpan(foregroundColorSpan5, length7, spannableStringBuilder3.length(), 17);
        textView8.setText(new SpannedString(spannableStringBuilder3));
        GuildCheckinDayView guildCheckinDayView = this.checkinDayView;
        if (guildCheckinDayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkinDayView");
            guildCheckinDayView = null;
        }
        guildCheckinDayView.E(checkinRsp.getCheckinCnt());
        if (checkinRsp.getFirstCheckin() != 0 && !forceShowActive) {
            if (checkinRsp.getFirstCheckin() == 1) {
                View view = this.myActiveContainer;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("myActiveContainer");
                    view = null;
                }
                view.setVisibility(8);
                TextView textView10 = this.openNotifyTips;
                if (textView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("openNotifyTips");
                } else {
                    textView2 = textView10;
                }
                textView2.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.myActiveContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myActiveContainer");
            view2 = null;
        }
        view2.setVisibility(0);
        TextView textView11 = this.openNotifyTips;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("openNotifyTips");
        } else {
            textView2 = textView11;
        }
        textView2.setVisibility(8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildCheckinDetailView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildCheckinDetailView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCheckinDetailView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context);
    }
}
