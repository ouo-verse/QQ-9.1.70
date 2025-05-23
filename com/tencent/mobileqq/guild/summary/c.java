package com.tencent.mobileqq.guild.summary;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.summary.GuildSummaryText;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yt1.DraftInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J0\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u0002H\u0007J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0003R2\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/summary/c;", "", "", "commonText", "Lcom/tencent/mobileqq/guild/summary/b;", "b", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "lastMessage", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "unreadInfo", "Lyt1/a;", "draftInfo", "msgText", "a", "c", "Lcom/tencent/mobileqq/guild/summary/GuildSummaryText;", "d", "", "e", "Ljava/util/ArrayList;", "Lhu1/a;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getInjectCustomSummaryProviders", "()Ljava/util/ArrayList;", "setInjectCustomSummaryProviders", "(Ljava/util/ArrayList;)V", "injectCustomSummaryProviders", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f235214a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/Guild/Inject_GuildCustomSummaryProvider.yml", version = 1)
    @NotNull
    private static ArrayList<hu1.a> injectCustomSummaryProviders;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f235216c;

    static {
        ArrayList arrayList = new ArrayList();
        f235216c = arrayList;
        arrayList.add(q02.a.class);
        f235216c.add(q02.b.class);
        c cVar = new c();
        f235214a = cVar;
        injectCustomSummaryProviders = new ArrayList<>();
        cVar.e();
    }

    c() {
    }

    @JvmStatic
    @NotNull
    public static final GuildSummaryUIData a(@Nullable LastMessage lastMessage, @Nullable UnreadInfo unreadInfo, @Nullable DraftInfo draftInfo, @NotNull String msgText) {
        boolean z16;
        LastMessage.SendState sendState;
        long j3;
        boolean z17;
        UnreadInfo unreadInfo2;
        boolean z18;
        Intrinsics.checkNotNullParameter(msgText, "msgText");
        ArrayList arrayList = new ArrayList();
        boolean z19 = true;
        if (draftInfo != null) {
            z16 = draftInfo.getHasDraft();
            if (z16 && (lastMessage == null || draftInfo.getTime() > lastMessage.getTime())) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                arrayList.add(new GuildSummaryText(draftInfo.getContent(), GuildSummaryText.TextStyle.NORMAL));
                return new GuildSummaryUIData(z16, LastMessage.SendState.SEND_SUCCESS, arrayList, draftInfo.getTime());
            }
        } else {
            z16 = false;
        }
        if (unreadInfo != null) {
            GuildSummaryText d16 = f235214a.d(unreadInfo);
            if (d16 != null) {
                arrayList.add(d16);
            } else if (!TextUtils.isEmpty(msgText)) {
                arrayList.add(new GuildSummaryText(msgText, GuildSummaryText.TextStyle.NORMAL));
            }
        }
        if (lastMessage != null) {
            for (hu1.a aVar : injectCustomSummaryProviders) {
                if (unreadInfo == null) {
                    unreadInfo2 = new UnreadInfo("", "", null, null, 0, 28, null);
                } else {
                    unreadInfo2 = unreadInfo;
                }
                List<GuildSummaryText> a16 = aVar.a(lastMessage, unreadInfo2);
                if (!a16.isEmpty()) {
                    arrayList.addAll(a16);
                    return new GuildSummaryUIData(z16, lastMessage.getSendState(), arrayList, lastMessage.getTime());
                }
            }
            StringBuilder sb5 = new StringBuilder();
            String selfTinyId = ((IGPSService) ch.l().getRuntimeService(IGPSService.class, "")).getSelfTinyId();
            if (lastMessage.getSenderUin().length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && !TextUtils.equals(selfTinyId, lastMessage.getSenderUin())) {
                sb5.append(lastMessage.getSenderNickname());
                sb5.append(MsgSummary.STR_COLON);
            }
            sb5.append(lastMessage.getContent());
            if (sb5.length() <= 0) {
                z19 = false;
            }
            if (z19) {
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "msgBuilder.toString()");
                arrayList.add(new GuildSummaryText(sb6, GuildSummaryText.TextStyle.NORMAL));
            }
        }
        if (lastMessage == null || (sendState = lastMessage.getSendState()) == null) {
            sendState = LastMessage.SendState.SEND_SUCCESS;
        }
        LastMessage.SendState sendState2 = sendState;
        if (lastMessage != null) {
            j3 = lastMessage.getTime();
        } else {
            j3 = 0;
        }
        return new GuildSummaryUIData(z16, sendState2, arrayList, j3);
    }

    @JvmStatic
    @NotNull
    public static final GuildSummaryUIData b(@NotNull String commonText) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(commonText, "commonText");
        LastMessage.SendState sendState = LastMessage.SendState.SEND_SUCCESS;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new GuildSummaryText(commonText, GuildSummaryText.TextStyle.NORMAL));
        return new GuildSummaryUIData(false, sendState, arrayListOf, 0L, 8, null);
    }

    @JvmStatic
    @NotNull
    public static final GuildSummaryUIData c(@Nullable LastMessage lastMessage, @Nullable DraftInfo draftInfo) {
        boolean z16;
        LastMessage.SendState sendState;
        ArrayList arrayList = new ArrayList();
        boolean z17 = false;
        if (draftInfo != null) {
            z16 = draftInfo.getHasDraft();
            if (z16 && (lastMessage == null || draftInfo.getTime() > lastMessage.getTime())) {
                z17 = true;
            }
            if (z17) {
                arrayList.add(new GuildSummaryText(draftInfo.getContent(), GuildSummaryText.TextStyle.NORMAL));
                return new GuildSummaryUIData(z16, LastMessage.SendState.SEND_SUCCESS, arrayList, 0L, 8, null);
            }
        } else {
            z16 = false;
        }
        if (lastMessage != null) {
            arrayList.add(new GuildSummaryText(new QQText(lastMessage.getContent(), 7, 15), GuildSummaryText.TextStyle.NORMAL));
        }
        if (lastMessage == null || (sendState = lastMessage.getSendState()) == null) {
            sendState = LastMessage.SendState.SEND_SUCCESS;
        }
        return new GuildSummaryUIData(z16, sendState, arrayList, 0L, 8, null);
    }

    private final GuildSummaryText d(UnreadInfo unreadInfo) {
        boolean z16;
        if (unreadInfo.getRelatedToMeString().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new GuildSummaryText(unreadInfo.getRelatedToMeString(), GuildSummaryText.TextStyle.HIGHLIGHT_BOLD);
        }
        return null;
    }

    @QAutoInitMethod
    private final void e() {
        com.tencent.mobileqq.qroute.utils.b.c(f235216c, injectCustomSummaryProviders);
        Logger.f235387a.d().i("GuildSummaryUIDataCreator", 1, "injected");
    }
}
