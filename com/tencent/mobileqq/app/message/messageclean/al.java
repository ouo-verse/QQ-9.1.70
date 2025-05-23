package com.tencent.mobileqq.app.message.messageclean;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.api.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BasicChatCacheInfo;
import com.tencent.qqnt.kernel.nativeinterface.ChatCacheDeleteInfo;
import com.tencent.qqnt.kernel.nativeinterface.ChatCacheInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildCategoryChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildChannelChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildChatCacheInfo;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class al {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<Long, ArrayList<g>> f196140a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<g> f196141b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<Long, Pair<g, ArrayList<Long>>> f196142c;

    public al() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f196140a = new HashMap<>();
        this.f196141b = new ArrayList<>();
        this.f196142c = new HashMap<>();
    }

    private String g(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1834626455:
                if (str.equals(PeerUid.DATALINE_PHONE_UID)) {
                    c16 = 0;
                    break;
                }
                break;
            case -1656358474:
                if (str.equals(PeerUid.DATALINE_PAD_UID)) {
                    c16 = 1;
                    break;
                }
                break;
            case 1930502276:
                if (str.equals(PeerUid.DATALINE_PC_UID)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return "\u6211\u7684\u624b\u673a";
            case 1:
                return "\u6211\u7684Pad";
            case 2:
                return "\u6211\u7684\u7535\u8111";
            default:
                return "";
        }
    }

    private void h(int i3, BasicChatCacheInfo basicChatCacheInfo) {
        String f16;
        if (basicChatCacheInfo != null && basicChatCacheInfo.getUin() != 0 && basicChatCacheInfo.getUid() != null) {
            h hVar = new h();
            hVar.f196223h = String.valueOf(basicChatCacheInfo.getUin());
            hVar.f196222g = basicChatCacheInfo.getUid();
            hVar.f196224i = com.tencent.nt.adapter.session.c.c(i3);
            hVar.f196217b = i3;
            hVar.f196218c = basicChatCacheInfo.getNickName();
            long chatSize = basicChatCacheInfo.getChatSize();
            hVar.f196221f = chatSize;
            if (chatSize <= 1000) {
                f16 = "< 1 KB";
            } else {
                f16 = q.f(chatSize);
            }
            hVar.f196219d = f16;
            if (!this.f196141b.contains(hVar)) {
                this.f196141b.add(hVar);
            }
            this.f196140a.put(Long.valueOf(Long.parseLong(hVar.f196223h)), new ArrayList<>());
            return;
        }
        QLog.i("NTChatCacheEntryWrapper", 1, " processBasicMsgCleanEntry invalid Data");
    }

    private void j(int i3, BasicChatCacheInfo basicChatCacheInfo) {
        String f16;
        if (basicChatCacheInfo != null && basicChatCacheInfo.getUid() != null) {
            h hVar = new h();
            hVar.f196223h = String.valueOf(basicChatCacheInfo.getUin());
            hVar.f196222g = basicChatCacheInfo.getUid();
            hVar.f196224i = com.tencent.nt.adapter.session.c.c(i3);
            hVar.f196217b = i3;
            hVar.f196218c = g(basicChatCacheInfo.getUid());
            long chatSize = basicChatCacheInfo.getChatSize();
            hVar.f196221f = chatSize;
            if (chatSize <= 1000) {
                f16 = "< 1 KB";
            } else {
                f16 = q.f(chatSize);
            }
            hVar.f196219d = f16;
            if (!this.f196141b.contains(hVar)) {
                this.f196141b.add(hVar);
            }
            this.f196140a.put(Long.valueOf(Long.parseLong(hVar.f196223h)), new ArrayList<>());
            return;
        }
        QLog.i("NTChatCacheEntryWrapper", 1, " processDataLineMsgCleanEntry invalid Data");
    }

    private void k(GuildChatCacheInfo guildChatCacheInfo) {
        String f16;
        int i3;
        String f17;
        int i16 = 1;
        if (guildChatCacheInfo != null) {
            long j3 = 0;
            if (guildChatCacheInfo.getGuildId() != 0) {
                w wVar = new w();
                wVar.f196254h = guildChatCacheInfo.getGuildAvatarSeq();
                wVar.f196253g = guildChatCacheInfo.getGuildId();
                wVar.f196221f = guildChatCacheInfo.getCacheSize();
                wVar.f196218c = guildChatCacheInfo.getGuildName();
                wVar.f196255i = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getAvatarUrl(String.valueOf(wVar.f196253g), wVar.f196254h, 140);
                long j16 = wVar.f196221f;
                if (j16 <= 1000) {
                    f16 = "< 1 KB";
                } else {
                    f16 = q.f(j16);
                }
                wVar.f196219d = f16;
                if (!this.f196141b.contains(wVar)) {
                    this.f196141b.add(wVar);
                }
                ArrayList<g> arrayList = new ArrayList<>();
                Iterator<GuildCategoryChatInfo> it = guildChatCacheInfo.getCategoryList().iterator();
                while (it.hasNext()) {
                    GuildCategoryChatInfo next = it.next();
                    u uVar = new u();
                    uVar.f196246g = next.getCategoryId();
                    String categoryName = next.getCategoryName();
                    uVar.f196218c = categoryName;
                    uVar.f196221f = j3;
                    uVar.f196247h = wVar.f196253g;
                    if (!TextUtils.isEmpty(categoryName)) {
                        arrayList.add(uVar);
                        i3 = 0;
                    } else {
                        QLog.i("NTChatCacheEntryWrapper", i16, " processGuildChatCacheInfo categoryId: " + uVar.f196246g + " is empty category ignore");
                        i3 = i16;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<GuildChannelChatInfo> it5 = next.getChannelList().iterator();
                    while (it5.hasNext()) {
                        GuildChannelChatInfo next2 = it5.next();
                        v vVar = new v();
                        w wVar2 = wVar;
                        vVar.f196221f = next2.getCacheSize();
                        vVar.f196250i = next2.getChannelId();
                        vVar.f196249h = next2.getTextChannelSubtypeId();
                        vVar.f196218c = next2.getChannelName();
                        vVar.f196248g = next2.getChannelType();
                        long j17 = vVar.f196221f;
                        if (j17 <= 1000) {
                            f17 = "< 1 KB";
                        } else {
                            f17 = q.f(j17);
                        }
                        vVar.f196219d = f17;
                        vVar.f196252k = uVar.f196246g;
                        vVar.f196251j = wVar2.f196253g;
                        arrayList.add(vVar);
                        arrayList2.add(Long.valueOf(vVar.f196250i));
                        it = it;
                        wVar = wVar2;
                    }
                    w wVar3 = wVar;
                    Iterator<GuildCategoryChatInfo> it6 = it;
                    if (i3 == 0) {
                        this.f196142c.put(Long.valueOf(uVar.f196246g), new Pair<>(uVar, arrayList2));
                    }
                    it = it6;
                    wVar = wVar3;
                    i16 = 1;
                    j3 = 0;
                }
                this.f196140a.put(Long.valueOf(wVar.f196253g), arrayList);
                return;
            }
        }
        QLog.i("NTChatCacheEntryWrapper", 1, " processGuildChatCacheInfo invalid Data");
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f196140a.clear();
        this.f196141b.clear();
        this.f196142c.clear();
    }

    public HashMap<Long, Pair<g, ArrayList<Long>>> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f196142c;
    }

    public ArrayList<ChatCacheDeleteInfo> c(List<g> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        }
        ArrayList<ChatCacheDeleteInfo> arrayList = new ArrayList<>();
        for (g gVar : list) {
            int i3 = gVar.f196216a;
            if (i3 != 10002 && i3 != 10003) {
                if (i3 != 10001) {
                    if (i3 == 10004) {
                        arrayList.add(new ChatCacheDeleteInfo(gVar.f196217b, gVar.f196221f, ((h) gVar).f196222g));
                    }
                } else {
                    arrayList.add(new ChatCacheDeleteInfo(gVar.f196217b, gVar.f196221f, String.valueOf(((v) gVar).f196250i)));
                }
            }
        }
        return arrayList;
    }

    public HashMap<Long, ArrayList<g>> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f196140a;
    }

    public ArrayList<g> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f196141b;
    }

    public List<g> f() {
        String f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<g> it = this.f196141b.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.f196216a == 10004) {
                if (next.f196220e) {
                    arrayList.add(next);
                    it.remove();
                }
            } else {
                w wVar = (w) next;
                ArrayList<g> arrayList2 = this.f196140a.get(Long.valueOf(wVar.f196253g));
                if (arrayList2 != null) {
                    Iterator<g> it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        g next2 = it5.next();
                        if (next2.f196220e) {
                            it5.remove();
                            if (next2.f196216a == 10002) {
                                u uVar = (u) next2;
                                this.f196142c.remove(Long.valueOf(uVar.f196246g));
                                QLog.d("NTChatCacheEntryWrapper", 1, "getNeedDeleteEntry remove mCategoryChannelsMap categoryName :" + uVar.f196218c + " categoryId :" + uVar.f196246g);
                            } else {
                                arrayList.add(next2);
                                wVar.f196221f -= next2.f196221f;
                            }
                        }
                    }
                    long j3 = wVar.f196221f;
                    if (j3 <= 1000) {
                        f16 = "< 1 KB";
                    } else {
                        f16 = q.f(j3);
                    }
                    wVar.f196219d = f16;
                    if (arrayList2.size() == 0) {
                        QLog.d("NTChatCacheEntryWrapper", 1, "mChildMap remove guildId :" + wVar.f196253g);
                        it.remove();
                        this.f196140a.remove(Long.valueOf(wVar.f196253g));
                    }
                }
            }
        }
        return arrayList;
    }

    public void i(List<ChatCacheInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        QLog.i("NTChatCacheEntryWrapper", 1, " processChatCacheEntities begin");
        a();
        for (ChatCacheInfo chatCacheInfo : list) {
            if (chatCacheInfo.getChatType() == 4) {
                k(chatCacheInfo.getGuildChatCacheInfo());
            } else if (chatCacheInfo.getChatType() == 8) {
                j(chatCacheInfo.getChatType(), chatCacheInfo.getBasicChatCacheInfo());
            } else {
                h(chatCacheInfo.getChatType(), chatCacheInfo.getBasicChatCacheInfo());
            }
        }
    }
}
