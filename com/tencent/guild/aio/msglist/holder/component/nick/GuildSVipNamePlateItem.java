package com.tencent.guild.aio.msglist.holder.component.nick;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildWebApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfoWithClientId;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b#\u0010$J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/GuildSVipNamePlateItem;", "Lcom/tencent/guild/aio/msglist/holder/component/nick/r;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "isRefresh", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProClientIdentityInfo;", "l", "", "o", "", "", "payloads", "a", "", "type", "f", "Landroid/content/Context;", "c", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/content/Context;", "context", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "ivNamePlate", "Landroid/widget/LinearLayout;", "e", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Landroid/widget/LinearLayout;", "namePlateContainer", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "curMsgItem", "<init>", "(Landroid/content/Context;)V", "g", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildSVipNamePlateItem extends r {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView ivNamePlate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy namePlateContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMsgItem curMsgItem;

    public GuildSVipNamePlateItem(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new GuildSVipNamePlateItem$namePlateContainer$2(this));
        this.namePlateContainer = lazy;
    }

    private final IGProClientIdentityInfo l(GuildMsgItem msgItem, boolean isRefresh) {
        Object obj;
        if (isRefresh) {
            IGProClientIdentityInfo b16 = com.tencent.guild.aio.util.h.f112401a.b(msgItem);
            com.tencent.guild.api.data.msglist.c preParseInfo = msgItem.getPreParseInfo();
            if (b16 == null) {
                obj = "EMPTY_OBJ";
            } else {
                obj = b16;
            }
            preParseInfo.j(obj);
            return b16;
        }
        Object clientIdentity = msgItem.getPreParseInfo().getClientIdentity();
        if (clientIdentity != null) {
            if (clientIdentity instanceof IGProClientIdentityInfo) {
                return (IGProClientIdentityInfo) clientIdentity;
            }
            return null;
        }
        IGProClientIdentityInfo b17 = com.tencent.guild.aio.util.h.f112401a.b(msgItem);
        msgItem.getPreParseInfo().j(b17);
        return b17;
    }

    private final LinearLayout n() {
        return (LinearLayout) this.namePlateContainer.getValue();
    }

    private final void o(final GuildMsgItem msgItem, boolean isRefresh) {
        List<IGProIdentityInfoWithClientId> defaultIdentityList;
        ImageView imageView;
        Object obj;
        boolean z16;
        n().setVisibility(8);
        IGProClientIdentityInfo l3 = l(msgItem, isRefresh);
        if (l3 == null) {
            QLog.w("GuildSVipNamePlateItem", 1, "updatePlateName clientIdentity is null! guildId=" + msgItem.getMsgRecord().guildId + "\uff0c msgSeq: " + msgItem.getMsgSeq() + ", tid: " + msgItem.getMsgRecord().senderUid + ".");
            return;
        }
        IGProClientIdentityByteInfo identityBytes = l3.getIdentityBytes();
        if (identityBytes != null && (defaultIdentityList = identityBytes.getDefaultIdentityList()) != null) {
            Iterator<T> it = defaultIdentityList.iterator();
            while (true) {
                imageView = null;
                if (it.hasNext()) {
                    obj = it.next();
                    if (((IGProIdentityInfoWithClientId) obj).getIdentity().getIdentityType() == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            IGProIdentityInfoWithClientId iGProIdentityInfoWithClientId = (IGProIdentityInfoWithClientId) obj;
            if (iGProIdentityInfoWithClientId != null) {
                if (QLog.isColorLevel()) {
                    byte[] plateData = iGProIdentityInfoWithClientId.getIdentity().getPlateData();
                    Intrinsics.checkNotNullExpressionValue(plateData, "it.identity.plateData");
                    QLog.i("GuildSVipNamePlateItem", 1, "updatePlateName plateData is : " + new String(plateData, Charsets.UTF_8));
                }
                byte[] plateData2 = iGProIdentityInfoWithClientId.getIdentity().getPlateData();
                Intrinsics.checkNotNullExpressionValue(plateData2, "it.identity.plateData");
                ImageView imageView2 = this.ivNamePlate;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivNamePlate");
                    imageView2 = null;
                }
                Resources resources = imageView2.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "ivNamePlate.resources");
                Drawable c16 = ig1.a.c("", plateData2, resources);
                if (c16 != null) {
                    n().setVisibility(0);
                    IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
                    ImageView imageView3 = this.ivNamePlate;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivNamePlate");
                        imageView3 = null;
                    }
                    iGuildDTReportApi.setElementExposureAllPolicy(imageView3, "em_sgrp_svip_medal");
                    ImageView imageView4 = this.ivNamePlate;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivNamePlate");
                        imageView4 = null;
                    }
                    imageView4.setImageDrawable(c16);
                    ImageView imageView5 = this.ivNamePlate;
                    if (imageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivNamePlate");
                    } else {
                        imageView = imageView5;
                    }
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.m
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            GuildSVipNamePlateItem.p(GuildSVipNamePlateItem.this, msgItem, view);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(GuildSVipNamePlateItem this$0, GuildMsgItem msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        ImageView imageView = this$0.ivNamePlate;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivNamePlate");
            imageView = null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
        linkedHashMap.put("sgrp_touin", str);
        Unit unit = Unit.INSTANCE;
        iGuildDTReportApi.reportDtEventManual(imageView, "em_sgrp_svip_medal", "clck", linkedHashMap);
        QRouteApi api = QRoute.api(IGuildWebApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildWebApi::class.java)");
        IGuildWebApi.a.a((IGuildWebApi) api, this$0.context, ig1.a.b(msgItem.getMsgRecord().guildId, msgItem.getMsgRecord().channelId), null, null, null, 28, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.nick.a
    public void a(@NotNull GuildMsgItem msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.curMsgItem = msgItem;
        o(msgItem, false);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.nick.r
    public void f(@NotNull GuildMsgItem msgItem, int type) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (type == 3) {
            o(msgItem, true);
        }
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final Context getContext() {
        return this.context;
    }
}
