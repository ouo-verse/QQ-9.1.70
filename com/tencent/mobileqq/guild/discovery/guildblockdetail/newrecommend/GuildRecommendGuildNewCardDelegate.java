package com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.discovery.avblockdetail.delegate.GuildBaseItemDelegate;
import com.tencent.mobileqq.guild.discovery.avblockdetail.model.GuildRecommendCardItem;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.GuildRecommendGuildCardDelegate;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendGuildNewCardDelegate;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.an;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jh1.ExtraData;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;
import wh2.em;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003&'(B!\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\n\u001a\u00020\u0004H\u0014J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0014J&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\u0014R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendGuildNewCardDelegate;", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/delegate/GuildBaseItemDelegate;", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/GuildRecommendCardItem;", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendGuildNewCardDelegate$MyViewHolder;", "", "o", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "holder", "", "payloads", "", "r", "Ljh1/a;", "e", "Ljh1/a;", "getExtraData", "()Ljh1/a;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$Styles;", "f", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$Styles;", "getStyles", "()Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$Styles;", "styles", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "<init>", "(Ljh1/a;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$Styles;)V", tl.h.F, "a", "b", "MyViewHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildRecommendGuildNewCardDelegate extends GuildBaseItemDelegate<GuildRecommendCardItem, MyViewHolder> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ExtraData extraData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRecommendGuildCardDelegate.Styles styles;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018JP\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J2\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendGuildNewCardDelegate$a;", "Landroid/text/style/ImageSpan;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "text", "", "start", "end", "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "Landroid/graphics/Paint;", "paint", "", "draw", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "Landroid/graphics/drawable/Drawable;", "d", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends ImageSpan {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Drawable d16) {
            super(d16);
            Intrinsics.checkNotNullParameter(d16, "d");
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NotNull Canvas canvas, @NotNull CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(paint, "paint");
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i3 = ((((fontMetricsInt.descent + y16) + y16) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2);
            canvas.save();
            canvas.translate(x16, i3);
            drawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(@NotNull Paint paint, @NotNull CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
            Intrinsics.checkNotNullParameter(paint, "paint");
            Intrinsics.checkNotNullParameter(text, "text");
            Drawable drawable = getDrawable();
            Rect bounds = drawable.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "drawable.bounds");
            if (fm5 != null) {
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                int i3 = fontMetricsInt.descent - fontMetricsInt.ascent;
                int height = bounds.height();
                int i16 = fontMetricsInt.ascent + (i3 / 2);
                if (height > i3) {
                    float f16 = height;
                    float f17 = i3 / f16;
                    bounds.right = (int) (bounds.width() * f17);
                    bounds.bottom = (int) (f16 * f17);
                    drawable.setBounds(bounds);
                    height = bounds.height();
                }
                int i17 = i16 - (height / 2);
                int i18 = height + i17;
                fm5.ascent = i17;
                fm5.descent = i18;
                fm5.top = i17;
                fm5.bottom = i18;
            }
            return bounds.width();
        }
    }

    public /* synthetic */ GuildRecommendGuildNewCardDelegate(ExtraData extraData, LifecycleOwner lifecycleOwner, GuildRecommendGuildCardDelegate.Styles styles, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(extraData, lifecycleOwner, (i3 & 4) != 0 ? GuildRecommendGuildCardDelegate.Styles.TOKEN : styles);
    }

    @Override // com.tencent.mobileqq.guild.discovery.avblockdetail.delegate.GuildBaseItemDelegate
    public int o() {
        return R.layout.f46;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull com.tencent.mobileqq.guild.discovery.avblockdetail.model.a item, @NotNull List<com.tencent.mobileqq.guild.discovery.avblockdetail.model.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof GuildRecommendCardItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull GuildRecommendCardItem item, @NotNull MyViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.r(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public MyViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new MyViewHolder(this.extraData, p(parent));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRecommendGuildNewCardDelegate(@NotNull ExtraData extraData, @NotNull LifecycleOwner viewLifecycleOwner, @NotNull GuildRecommendGuildCardDelegate.Styles styles) {
        super(viewLifecycleOwner);
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(styles, "styles");
        this.extraData = extraData;
        this.styles = styles;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010*\u001a\u00020&\u0012\u0006\u0010?\u001a\u00020>\u00a2\u0006\u0004\b@\u0010AJ\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0016\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u001a\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u001e\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010!0 2\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0007H\u0016R\u0017\u0010*\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00101\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u00100R\u0014\u00104\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00100R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u00106R\u0014\u00109\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00100R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendGuildNewCardDelegate$MyViewHolder;", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/delegate/GuildBaseItemDelegate$a;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/n;", "", "curText", "", "targetText", "", "w", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/GuildRecommendCardItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", HippyTKDListViewAdapter.X, "guildProfileStr", BdhLogUtil.LogTag.Tag_Conn, "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendLabel;", "tagList", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isGuest", "D", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalInfo", "guildNameStr", "E", "u", "Landroid/widget/TextView;", "textView", "text", "J", ReportConstant.COSTREPORT_PREFIX, "", "", "t", "r", NodeProps.VISIBLE, "onVisibleChanged", "Ljh1/a;", "Ljh1/a;", "getExtraData", "()Ljh1/a;", WadlProxyConsts.EXTRA_DATA, "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "guildAvatar", "G", "Landroid/widget/TextView;", "guildName", "recommendTag1", "I", "recommendTag2", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "joinBtn", "K", "guildProfile", "Lcom/tencent/mobileqq/guild/api/impl/GuildDTReportApiImpl;", "L", "Lcom/tencent/mobileqq/guild/api/impl/GuildDTReportApiImpl;", "reportApi", "Landroid/view/View;", "itemView", "<init>", "(Ljh1/a;Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class MyViewHolder extends GuildBaseItemDelegate.a implements com.tencent.mobileqq.guild.widget.adapterdelegates.n {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ExtraData extraData;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ImageView guildAvatar;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView guildName;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final TextView recommendTag1;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TextView recommendTag2;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final QUIButton joinBtn;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final TextView guildProfile;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private final GuildDTReportApiImpl reportApi;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendGuildNewCardDelegate$MyViewHolder$a", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class a extends GuildPicStateListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Ref.IntRef f216714e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f216715f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f216716h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ MyViewHolder f216717i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Ref.IntRef intRef, int i3, String str, MyViewHolder myViewHolder) {
                super(false);
                this.f216714e = intRef;
                this.f216715f = i3;
                this.f216716h = str;
                this.f216717i = myViewHolder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void e(MyViewHolder this$0, SpannableStringBuilder spannedString) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(spannedString, "$spannedString");
                this$0.guildName.setText(spannedString);
            }

            @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
            public void c(@Nullable LoadState state, @Nullable Option option) {
                Bitmap bitmap;
                if (state == LoadState.STATE_SUCCESS) {
                    if (option != null) {
                        bitmap = option.getResultBitMap();
                    } else {
                        bitmap = null;
                    }
                    if (bitmap != null) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(BaseApplication.context.getResources(), option.getResultBitMap());
                        Ref.IntRef intRef = this.f216714e;
                        float width = option.getResultBitMap().getWidth() / option.getResultBitMap().getHeight();
                        int i3 = this.f216715f;
                        intRef.element = (int) (width * i3);
                        bitmapDrawable.setBounds(0, 0, this.f216714e.element, i3);
                        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) (this.f216716h + " "));
                        spannableStringBuilder.append(" ", new a(bitmapDrawable), 33);
                        TextView textView = this.f216717i.guildName;
                        final MyViewHolder myViewHolder = this.f216717i;
                        textView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.n
                            @Override // java.lang.Runnable
                            public final void run() {
                                GuildRecommendGuildNewCardDelegate.MyViewHolder.a.e(GuildRecommendGuildNewCardDelegate.MyViewHolder.this, spannableStringBuilder);
                            }
                        });
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyViewHolder(@NotNull ExtraData extraData, @NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.extraData = extraData;
            View findViewById = itemView.findViewById(R.id.vzu);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.guild_avatar)");
            this.guildAvatar = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.wrw);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.guild_name)");
            this.guildName = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f919756m);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tag1)");
            this.recommendTag1 = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f919856n);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tag2)");
            this.recommendTag2 = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.dzc);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.join_btn)");
            this.joinBtn = (QUIButton) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.wty);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.guild_profile)");
            this.guildProfile = (TextView) findViewById6;
            this.reportApi = new GuildDTReportApiImpl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void A(final MyViewHolder this$0, final GuildRecommendCardItem item, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                if (ch.j0(item.getGuildId())) {
                    JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
                    jumpParam.d(!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected());
                    jumpParam.c(true);
                    com.tencent.mobileqq.guild.channel.joinchannel.h.a(this$0.itemView.getContext(), GuildRecommendGuildCardDelegate.INSTANCE.e(this$0.extraData.getTabType(), this$0.extraData.getPageFrom(), item, this$0.extraData.getMainSource(), this$0.extraData.getSubSource()), jumpParam, "guild.re.new.GuildRecommendGuildNewCardDelegate", new bv() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.l
                        @Override // vh2.bv
                        public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                            GuildRecommendGuildNewCardDelegate.MyViewHolder.B(GuildRecommendGuildNewCardDelegate.MyViewHolder.this, item, i3, str, iGProSecurityResult, iGProJoinGuildResult);
                        }
                    });
                } else {
                    this$0.u(item);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void B(MyViewHolder this$0, GuildRecommendCardItem item, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
                this$0.D(false);
                item.setJoinGuildFlag(2);
                this$0.u(item);
                return;
            }
            com.tencent.mobileqq.guild.channel.joinchannel.h.c(this$0.itemView.getContext(), i3, str, iGProSecurityResult);
        }

        private final void C(String guildProfileStr) {
            if (this.recommendTag1.getVisibility() == 8 && this.recommendTag2.getVisibility() == 8 && !StringUtil.isEmpty(guildProfileStr)) {
                this.guildProfile.setVisibility(0);
                this.guildProfile.setText(guildProfileStr);
            } else {
                this.guildProfile.setVisibility(8);
            }
        }

        private final void D(boolean isGuest) {
            int i3;
            QUIButton qUIButton = this.joinBtn;
            Context context = qUIButton.getContext();
            if (isGuest) {
                i3 = R.string.f155561hu;
            } else {
                i3 = R.string.f143610mj;
            }
            qUIButton.setText(context.getString(i3));
            qUIButton.setPadding(0, qUIButton.getPaddingTop(), 0, qUIButton.getPaddingBottom());
        }

        private final void E(IGProMedalInfo medalInfo, String guildNameStr) {
            if (medalInfo != null && medalInfo.getOfficialMedalInfoExt().getIsOffical()) {
                an.Companion companion = an.INSTANCE;
                String d16 = companion.d();
                Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = companion.c();
                int a16 = companion.a();
                Option url = new Option().setUrl(d16);
                url.setRequestWidth(intRef.element);
                url.setRegionHeight(a16);
                url.setFailedDrawableColor(this.itemView.getResources().getColor(R.color.guild_color_ebebeb_313138));
                url.setLoadingDrawableColor(this.itemView.getResources().getColor(R.color.guild_color_ebebeb_313138));
                com.tencent.mobileqq.guild.picload.e.a().f(url, new a(intRef, a16, guildNameStr, this));
            }
        }

        private final void H(List<? extends IGProRecommendLabel> tagList) {
            boolean z16;
            if (!tagList.isEmpty()) {
                int i3 = 0;
                loop0: while (true) {
                    z16 = false;
                    for (IGProRecommendLabel iGProRecommendLabel : tagList) {
                        if (iGProRecommendLabel.getBussiLabelType() == 1 && !TextUtils.isEmpty(iGProRecommendLabel.getLabelName())) {
                            J(this.recommendTag1, iGProRecommendLabel.getLabelName());
                        } else if (iGProRecommendLabel.getBussiLabelType() != 2) {
                            continue;
                        } else if (TextUtils.isEmpty(this.recommendTag1.getText())) {
                            J(this.recommendTag1, iGProRecommendLabel.getLabelName());
                        } else {
                            if (TextUtils.isEmpty(iGProRecommendLabel.getLabelName())) {
                                break;
                            }
                            if (TextUtils.equals(this.recommendTag2.getText(), iGProRecommendLabel.getLabelName())) {
                                z16 = true;
                            } else {
                                this.recommendTag2.setText(iGProRecommendLabel.getLabelName());
                                this.recommendTag2.setVisibility(4);
                                this.recommendTag2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.k
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        GuildRecommendGuildNewCardDelegate.MyViewHolder.I(GuildRecommendGuildNewCardDelegate.MyViewHolder.this);
                                    }
                                });
                            }
                        }
                    }
                }
                TextView textView = this.recommendTag2;
                if (!z16) {
                    i3 = 4;
                }
                textView.setVisibility(i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void I(MyViewHolder this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.recommendTag2.getVisibility() == 4 && this$0.recommendTag2.getLayout() != null) {
                Layout layout = this$0.recommendTag2.getLayout();
                Intrinsics.checkNotNullExpressionValue(layout, "recommendTag2.layout");
                if (layout.getEllipsisCount(0) > 0) {
                    this$0.recommendTag2.setVisibility(8);
                    this$0.recommendTag2.setText("");
                } else {
                    this$0.recommendTag2.setVisibility(0);
                }
            }
        }

        private final void J(TextView textView, String text) {
            if (!TextUtils.isEmpty(text)) {
                textView.setVisibility(0);
                textView.setText(text);
            } else {
                textView.setVisibility(8);
            }
        }

        private final void s(GuildRecommendCardItem item) {
            this.reportApi.setElementExposureAllAndClickPolicy(this.itemView, "em_sgrp_discover_channel_card");
            VideoReport.setPageId(this.itemView, "pg_sgrp_discover_recommend_card");
            VideoReport.setElementParams(this.itemView, t(item));
            VideoReport.setElementReuseIdentifier(this.itemView, "itemView-" + item.hashCode());
            VideoReport.reportEvent("imp", this.itemView, t(item));
            this.reportApi.setElementClickParams(this.joinBtn, "em_sgrp_discover_channel_card_join_btn", t(item));
            VideoReport.setElementReuseIdentifier(this.joinBtn, "joinGuildBtn-" + item.hashCode());
            VideoReport.reportEvent("imp", this.joinBtn, t(item));
            VideoReport.setElementClickPolicy(this.joinBtn, ClickPolicy.REPORT_ALL);
        }

        private final Map<String, Object> t(GuildRecommendCardItem item) {
            String str;
            Map<String, Object> mutableMapOf;
            int i3;
            if (item.getFriendJoinedNum() > 0) {
                str = String.valueOf(item.getFriendJoinedNum());
            } else {
                str = "";
            }
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_channel_id", item.getGuildId()), TuplesKt.to("sgrp_category_type", item.getCurCategoryName()), TuplesKt.to("sgrp_channel_category", item.getCurCategoryName()), TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, item.getTraceId()), TuplesKt.to("sgrp_user_place", Integer.valueOf(item.getItemCategoryPosition())), TuplesKt.to("sgrp_channel_tags", item.getChannelStatusText()), TuplesKt.to("sgrp_relationship_tags", str), TuplesKt.to("sgrp_state_tags", item.getWuJiTags()));
            mutableMapOf.put("sgrp_user_place_card", Integer.valueOf(item.getItemCategoryPosition()));
            if (!item.getTagList().isEmpty()) {
                i3 = 0;
                for (IGProRecommendLabel iGProRecommendLabel : item.getTagList()) {
                    if (iGProRecommendLabel.getBussiLabelType() == 1) {
                        mutableMapOf.put("sgrp_search_tag1", iGProRecommendLabel.getLabelName());
                        i3++;
                    }
                    if (iGProRecommendLabel.getBussiLabelType() == 2) {
                        mutableMapOf.put("sgrp_search_tag2", iGProRecommendLabel.getLabelName());
                        i3++;
                    }
                }
            } else {
                i3 = 0;
            }
            if (!item.getMedalInfoList().isEmpty()) {
                List<IGProMedalInfo> t16 = GuildMedalUtils.t(new ArrayList(item.getMedalInfoList()), 0, 2, null);
                StringBuffer stringBuffer = new StringBuffer();
                if (!t16.isEmpty()) {
                    i3++;
                    for (IGProMedalInfo iGProMedalInfo : t16) {
                        if (!TextUtils.isEmpty(iGProMedalInfo.getName())) {
                            stringBuffer.append(iGProMedalInfo.getName());
                            stringBuffer.append(",");
                        }
                    }
                    mutableMapOf.put("sgrp_search_tag4", stringBuffer);
                }
            }
            mutableMapOf.put("sgrp_search_tag_count", Integer.valueOf(i3));
            mutableMapOf.putAll(item.getDtParams());
            return mutableMapOf;
        }

        private final void u(GuildRecommendCardItem item) {
            ArrayList<String> arrayListOf;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            GuildRecommendGuildCardDelegate.Companion companion = GuildRecommendGuildCardDelegate.INSTANCE;
            GuildJumpUtil.n(context, companion.e(this.extraData.getTabType(), this.extraData.getPageFrom(), item, this.extraData.getMainSource(), this.extraData.getSubSource()));
            IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(item.getGuildId());
            iGPSService.reportUserViewGuild(arrayListOf, mh1.a.c(mh1.a.f416777a, this.extraData.getPageFrom(), null, 2, null), GuildRecommendGuildCardDelegate.Companion.c(companion, this.extraData.getTabType(), this.extraData.getPageFrom(), null, 4, null), 2, new em() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.m
                @Override // wh2.em
                public final void onResult(int i3, String str) {
                    GuildRecommendGuildNewCardDelegate.MyViewHolder.v(i3, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void v(int i3, String str) {
            if (i3 != 0) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str2 = "reportUserViewGuild failed result: " + i3 + ", errMsg: " + str;
                if (str2 instanceof String) {
                    bVar.a().add(str2);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("guild.re.new.GuildRecommendGuildNewCardDelegate", 1, (String) it.next(), null);
                }
            }
        }

        private final boolean w(CharSequence curText, String targetText) {
            SpannedString spannedString;
            CharSequence trimEnd;
            if (TextUtils.equals(curText, targetText)) {
                return false;
            }
            if (curText instanceof SpannedString) {
                spannedString = (SpannedString) curText;
            } else {
                spannedString = null;
            }
            if (spannedString != null) {
                trimEnd = StringsKt__StringsKt.trimEnd(curText);
                if (TextUtils.equals(trimEnd, targetText)) {
                    return false;
                }
                return true;
            }
            return true;
        }

        private final void x(final GuildRecommendCardItem item) {
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildRecommendGuildNewCardDelegate.MyViewHolder.y(GuildRecommendGuildNewCardDelegate.MyViewHolder.this, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(MyViewHolder this$0, GuildRecommendCardItem item, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                this$0.u(item);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void z(final GuildRecommendCardItem item) {
            this.joinBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildRecommendGuildNewCardDelegate.MyViewHolder.A(GuildRecommendGuildNewCardDelegate.MyViewHolder.this, item, view);
                }
            });
        }

        public final void r(@NotNull GuildRecommendCardItem item) {
            Object firstOrNull;
            Intrinsics.checkNotNullParameter(item, "item");
            v.f235697a.j(item.getGuildIconUrl(), this.guildAvatar, new Function1<Option, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendGuildNewCardDelegate$MyViewHolder$bindData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Option option) {
                    invoke2(option);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Option loadImage) {
                    Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
                    loadImage.setFailedDrawableColor(GuildRecommendGuildNewCardDelegate.MyViewHolder.this.itemView.getResources().getColor(R.color.guild_color_ebebeb_313138));
                    loadImage.setLoadingDrawableColor(GuildRecommendGuildNewCardDelegate.MyViewHolder.this.itemView.getResources().getColor(R.color.guild_color_ebebeb_313138));
                }
            });
            if (w(this.guildName.getText(), item.getGuildName())) {
                this.guildName.setText(item.getGuildName());
            }
            x(item);
            H(item.getTagList());
            C(item.getGuildProfile());
            z(item);
            D(ch.j0(item.getGuildId()));
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) item.getMedalInfoList());
            E((IGProMedalInfo) firstOrNull, item.getGuildName());
            s(item);
        }

        @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.n
        public void onVisibleChanged(boolean visible) {
        }
    }
}
