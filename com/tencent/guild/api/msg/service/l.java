package com.tencent.guild.api.msg.service;

import com.tencent.aio.data.AIOSession;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qqguildsdk.data.GProUnreadCntUpData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigateInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigateResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUnreadCnt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUnreadCntInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import er0.a;
import fr0.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sr0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\rH\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0010J \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017\"\u0004\b\u0000\u0010\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001aJ$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017J\u000e\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"J \u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00170(2\u0006\u0010'\u001a\u00020&J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00172\u0010\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0017\u00a8\u0006."}, d2 = {"Lcom/tencent/guild/api/msg/service/l;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "e", "", "aioChatType", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUnreadCntInfo;", "info", "Lfr0/a;", "j", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUnreadCnt;", "Lfr0/a$a;", "i", "Lcom/tencent/aio/data/AIOSession;", "aioSession", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProContact;", "d", "T", "", "msgRecordList", "g", "Lcom/tencent/qqnt/msg/d;", "f", "Lsr0/b;", "aioMsgElements", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProNavigateResult;", "result", "Ler0/a;", tl.h.F, "Lcom/tencent/mobileqq/qqguildsdk/data/cd;", "infoMap", "", "l", "infoList", "k", "<init>", "()V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f112634a = new l();

    l() {
    }

    private final int b(int aioChatType) {
        if (aioChatType == 1) {
            return 1;
        }
        if (aioChatType == 2) {
            return 2;
        }
        if (aioChatType == 3) {
            return 3;
        }
        if (aioChatType == 4) {
            return 4;
        }
        return 0;
    }

    private final GuildMsgItem e(MsgRecord msgRecord) {
        return new GuildMsgItem(msgRecord);
    }

    private final a.C10335a i(GProUnreadCnt info) {
        return new a.C10335a(info.type, info.cnt);
    }

    private final fr0.a j(GProUnreadCntInfo info) {
        GProContact gProContact = info.peer;
        String str = gProContact.guildId;
        String str2 = gProContact.peerUid;
        GProUnreadCnt gProUnreadCnt = info.showUnreadCnt;
        Intrinsics.checkNotNullExpressionValue(gProUnreadCnt, "info.showUnreadCnt");
        a.C10335a i3 = i(gProUnreadCnt);
        GProUnreadCnt gProUnreadCnt2 = info.allUnreadCnt;
        Intrinsics.checkNotNullExpressionValue(gProUnreadCnt2, "info.allUnreadCnt");
        a.C10335a i16 = i(gProUnreadCnt2);
        GProUnreadCnt gProUnreadCnt3 = info.atmeUnreadCnt;
        Intrinsics.checkNotNullExpressionValue(gProUnreadCnt3, "info.atmeUnreadCnt");
        a.C10335a i17 = i(gProUnreadCnt3);
        GProUnreadCnt gProUnreadCnt4 = info.atallUnreadCnt;
        Intrinsics.checkNotNullExpressionValue(gProUnreadCnt4, "info.atallUnreadCnt");
        return new fr0.a(str, str2, i3, i16, i17, i(gProUnreadCnt4));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00e4, code lost:
    
        if (r6 != 512) goto L50;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList<MsgElement> a(@NotNull List<sr0.b> aioMsgElements) {
        a.ReplyElement replyElement;
        CharSequence trimEnd;
        Intrinsics.checkNotNullParameter(aioMsgElements, "aioMsgElements");
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        QRouteApi api = QRoute.api(IMsgUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMsgUtilApi::class.java)");
        IMsgUtilApi iMsgUtilApi = (IMsgUtilApi) api;
        for (sr0.b bVar : aioMsgElements) {
            int elementType = bVar.getElementType();
            if (elementType != 1) {
                if (elementType != 2) {
                    if (elementType != 3) {
                        if (elementType != 5) {
                            if (elementType != 6) {
                                if (elementType == 7 && (replyElement = bVar.getReplyElement()) != null) {
                                    arrayList.add(iMsgUtilApi.createReplyElement(replyElement.getReplyMsgId(), replyElement.getReplyNick(), replyElement.getReplyContent()));
                                }
                            } else {
                                a.FaceElement faceElement = bVar.getFaceElement();
                                if (faceElement != null) {
                                    arrayList.add(m.f112635a.a(faceElement));
                                }
                            }
                        } else {
                            a.VideoElement videoElement = bVar.getVideoElement();
                            if (videoElement != null) {
                                arrayList.add(iMsgUtilApi.createVideoElement(videoElement.getOrigPath(), videoElement.getSubBusiType(), videoElement.getQuality(), videoElement.getThumbPath()));
                            }
                        }
                    } else {
                        a.FileElement fileElement = bVar.getFileElement();
                        if (fileElement != null) {
                            arrayList.add(iMsgUtilApi.createFileElement(fileElement.getOrigPath()));
                        }
                    }
                } else {
                    a.AIOPicElement picElement = bVar.getPicElement();
                    if (picElement != null) {
                        arrayList.add(iMsgUtilApi.createPicElementForGuild(picElement.getOrigPath(), picElement.getQuality(), picElement.getSubType()));
                    }
                }
            } else {
                TextElement textElement = new TextElement();
                a.TextElement textElement2 = bVar.getTextElement();
                if (textElement2 != null) {
                    trimEnd = StringsKt__StringsKt.trimEnd((CharSequence) textElement2.getContent());
                    textElement.content = trimEnd.toString();
                    int atType = textElement2.getAtType();
                    if (atType != 1) {
                        if (atType != 2) {
                            if (atType != 8) {
                                if (atType != 16) {
                                    if (atType != 64) {
                                    }
                                }
                                textElement.atType = textElement2.getAtType();
                                textElement.atChannelId = Long.valueOf(textElement2.getAtTinyId());
                            } else {
                                textElement.atType = textElement2.getAtType();
                                textElement.atRoleId = textElement2.getAtRoleId();
                                textElement.atRoleColor = textElement2.getAtRoleColor();
                                textElement.atRoleName = textElement2.getAtRoleName();
                            }
                        } else {
                            textElement.atType = textElement2.getAtType();
                            textElement.atTinyId = textElement2.getAtTinyId();
                            textElement.atUid = textElement2.getAtUid();
                        }
                    }
                    textElement.atType = textElement2.getAtType();
                }
                arrayList.add(iMsgUtilApi.createTextElement(textElement));
            }
        }
        return arrayList;
    }

    @NotNull
    public final Contact c(@NotNull AIOSession aioSession) {
        Intrinsics.checkNotNullParameter(aioSession, "aioSession");
        return new Contact(b(aioSession.c().e()), aioSession.c().j(), aioSession.c().f());
    }

    @NotNull
    public final GProContact d(@NotNull AIOSession aioSession) {
        Intrinsics.checkNotNullParameter(aioSession, "aioSession");
        return new GProContact(b(aioSession.c().e()), aioSession.c().j(), aioSession.c().f());
    }

    @NotNull
    public final GuildMsgItem f(@NotNull com.tencent.qqnt.msg.d msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return new GuildMsgItem(msgRecord.a());
    }

    @NotNull
    public final <T> List<GuildMsgItem> g(@NotNull List<? extends T> msgRecordList) {
        GuildMsgItem guildMsgItem;
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        ArrayList arrayList = new ArrayList();
        for (T t16 : msgRecordList) {
            if (t16 instanceof MsgRecord) {
                guildMsgItem = e((MsgRecord) t16);
            } else if (t16 instanceof com.tencent.qqnt.msg.d) {
                guildMsgItem = f((com.tencent.qqnt.msg.d) t16);
            } else {
                guildMsgItem = null;
            }
            if (guildMsgItem != null) {
                arrayList.add(guildMsgItem);
            }
        }
        return arrayList;
    }

    @NotNull
    public final er0.a h(@NotNull GProNavigateResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        er0.a aVar = new er0.a();
        Iterator<GProNavigateInfo> it = result.seqList.iterator();
        while (it.hasNext()) {
            GProNavigateInfo next = it.next();
            aVar.b().add(new a.C10261a(next.msgSeq, next.type.ordinal()));
        }
        aVar.d(result.beginSeq);
        aVar.e(result.unread);
        return aVar;
    }

    @NotNull
    public final List<fr0.a> k(@Nullable List<GProUnreadCntInfo> infoList) {
        fr0.a j3;
        ArrayList arrayList = new ArrayList();
        if (infoList != null) {
            for (GProUnreadCntInfo gProUnreadCntInfo : infoList) {
                if (gProUnreadCntInfo != null && (j3 = f112634a.j(gProUnreadCntInfo)) != null) {
                    arrayList.add(j3);
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final Map<Integer, List<fr0.a>> l(@NotNull GProUnreadCntUpData infoMap) {
        Intrinsics.checkNotNullParameter(infoMap, "infoMap");
        HashMap hashMap = new HashMap();
        if (infoMap.a() == null) {
            return hashMap;
        }
        HashMap<Integer, ArrayList<GProUnreadCntInfo>> a16 = infoMap.a();
        Intrinsics.checkNotNull(a16);
        for (Map.Entry<Integer, ArrayList<GProUnreadCntInfo>> entry : a16.entrySet()) {
        }
        return hashMap;
    }
}
