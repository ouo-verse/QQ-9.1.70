package com.tencent.relation.common.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.api.ISelectNtSaveRecentUserApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentGetContactCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RelationNTRecentListApiImpl implements IRelationNTRecentListApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RelationNTRecentListApiImpl";
    private List<RecentUser> recentUserListCache;

    public RelationNTRecentListApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.recentUserListCache = new CopyOnWriteArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDisplayName(RecentContactInfo recentContactInfo) {
        if (!TextUtils.isEmpty(recentContactInfo.getRemark())) {
            return recentContactInfo.getRemark();
        }
        if (!TextUtils.isEmpty(recentContactInfo.getPeerName())) {
            return recentContactInfo.getPeerName();
        }
        return recentContactInfo.getSendNickName();
    }

    @Override // com.tencent.relation.common.api.IRelationNTRecentListApi
    public int getChatTypeForRecentList(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        if (i3 != 1) {
            if (i3 == 2) {
                return 1;
            }
            if (i3 != 3) {
                if (i3 != 16) {
                    if (i3 != 111) {
                        if (i3 != 99 && i3 != 100) {
                            return -1;
                        }
                        return 1000;
                    }
                    return 1006;
                }
                return 10027;
            }
            return 3000;
        }
        return 0;
    }

    @Override // com.tencent.relation.common.api.IRelationNTRecentListApi
    public void getRecentList(AppRuntime appRuntime, RecentContactListener recentContactListener, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, recentContactListener, Boolean.valueOf(z16));
            return;
        }
        if (appRuntime == null) {
            QLog.e(TAG, 1, "getRecentList is error! appRuntime is invalid!");
            return;
        }
        aa recentContactService = ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "all")).getRecentContactService();
        if (recentContactService == null) {
            QLog.e(TAG, 1, "getRecentList is error! recentContactService is invalid!");
        } else {
            recentContactService.getRecentContactInfos(new IKernelRecentGetContactCallback(recentContactListener, z16) { // from class: com.tencent.relation.common.api.impl.RelationNTRecentListApiImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ RecentContactListener f364662a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ boolean f364663b;

                {
                    this.f364662a = recentContactListener;
                    this.f364663b = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RelationNTRecentListApiImpl.this, recentContactListener, Boolean.valueOf(z16));
                    }
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentGetContactCallback
                public void onResult(int i3, String str, ArrayList<RecentContactInfo> arrayList) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), str, arrayList);
                    } else {
                        ThreadManagerV2.excute(new Runnable(i3, str, arrayList) { // from class: com.tencent.relation.common.api.impl.RelationNTRecentListApiImpl.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ int f364665d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ String f364666e;

                            /* renamed from: f, reason: collision with root package name */
                            final /* synthetic */ ArrayList f364667f;

                            {
                                this.f364665d = i3;
                                this.f364666e = str;
                                this.f364667f = arrayList;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, Integer.valueOf(i3), str, arrayList);
                                }
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:40:0x00d2, code lost:
                            
                                if (r8 != 100) goto L53;
                             */
                            /* JADX WARN: Removed duplicated region for block: B:48:0x016f A[SYNTHETIC] */
                            /* JADX WARN: Removed duplicated region for block: B:52:0x007a A[SYNTHETIC] */
                            /* JADX WARN: Removed duplicated region for block: B:57:0x0132  */
                            /* JADX WARN: Removed duplicated region for block: B:59:0x0137  */
                            @Override // java.lang.Runnable
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public void run() {
                                String valueOf;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (AnonymousClass1.this.f364662a == null) {
                                    QLog.e(RelationNTRecentListApiImpl.TAG, 1, "getRecentList is error! recentContactListener is invalid");
                                    return;
                                }
                                ArrayList arrayList2 = new ArrayList();
                                if (this.f364665d != 0) {
                                    QLog.e(RelationNTRecentListApiImpl.TAG, 1, "getRecentList is error! result is " + this.f364665d + " errMsg is " + this.f364666e);
                                    AnonymousClass1.this.f364662a.onResult(arrayList2);
                                    return;
                                }
                                ArrayList arrayList3 = this.f364667f;
                                if (arrayList3 != null && !arrayList3.isEmpty()) {
                                    ArrayList arrayList4 = new ArrayList(this.f364667f);
                                    ISelectNtSaveRecentUserApi iSelectNtSaveRecentUserApi = (ISelectNtSaveRecentUserApi) QRoute.api(ISelectNtSaveRecentUserApi.class);
                                    IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
                                    Iterator it = arrayList4.iterator();
                                    while (it.hasNext()) {
                                        RecentContactInfo recentContactInfo = (RecentContactInfo) it.next();
                                        if (RelationNTRecentListApiImpl.this.getChatTypeForRecentList(recentContactInfo.getChatType()) != -1 && ((IChatsUtil) QRoute.api(IChatsUtil.class)).isShowInMainChatList(recentContactInfo)) {
                                            RecentUser recentUser = new RecentUser("", RelationNTRecentListApiImpl.this.getChatTypeForRecentList(recentContactInfo.getChatType()));
                                            int chatType = recentContactInfo.getChatType();
                                            if (chatType != 1) {
                                                if (chatType != 2 && chatType != 3) {
                                                    if (chatType != 16) {
                                                        if (chatType != 111) {
                                                            if (chatType != 99) {
                                                            }
                                                        }
                                                        if (recentContactInfo.getPeerUin() != 0) {
                                                            valueOf = recentContactInfo.getPeerUid();
                                                        } else {
                                                            valueOf = String.valueOf(recentContactInfo.getPeerUin());
                                                        }
                                                        recentUser.uin = valueOf;
                                                        recentUser.displayName = RelationNTRecentListApiImpl.this.getDisplayName(recentContactInfo);
                                                        recentUser.lastmsgtime = recentContactInfo.getMsgTime();
                                                        recentUser.senderUin = String.valueOf(recentContactInfo.getSenderUin());
                                                    } else {
                                                        GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
                                                        recentUser.displayName = guildContactInfo.guildName;
                                                        String str2 = guildContactInfo.guildId;
                                                        recentUser.troopUin = str2;
                                                        recentUser.uin = str2;
                                                    }
                                                } else {
                                                    recentUser.uin = recentContactInfo.getPeerUid();
                                                    recentUser.displayName = RelationNTRecentListApiImpl.this.getDisplayName(recentContactInfo);
                                                    recentUser.lastmsgtime = recentContactInfo.getMsgTime();
                                                    recentUser.troopUin = recentContactInfo.getPeerUid();
                                                    recentUser.senderUin = String.valueOf(recentContactInfo.getSenderUin());
                                                }
                                                if (recentContactInfo.getChatType() == 16 || AnonymousClass1.this.f364663b) {
                                                    if (!iSelectNtSaveRecentUserApi.shouldAddToList(recentUser, true)) {
                                                        arrayList2.add(recentUser);
                                                    }
                                                }
                                            }
                                            if (iRelationNTUinAndUidApi.isValidUin(String.valueOf(recentContactInfo.getPeerUin()))) {
                                                iRelationNTUinAndUidApi.saveUidByUin(String.valueOf(recentContactInfo.getPeerUin()), recentContactInfo.getPeerUid());
                                            }
                                            if (recentContactInfo.getPeerUin() != 0) {
                                            }
                                            recentUser.uin = valueOf;
                                            recentUser.displayName = RelationNTRecentListApiImpl.this.getDisplayName(recentContactInfo);
                                            recentUser.lastmsgtime = recentContactInfo.getMsgTime();
                                            recentUser.senderUin = String.valueOf(recentContactInfo.getSenderUin());
                                            if (recentContactInfo.getChatType() == 16) {
                                            }
                                            if (!iSelectNtSaveRecentUserApi.shouldAddToList(recentUser, true)) {
                                            }
                                        }
                                    }
                                    RelationNTRecentListApiImpl.this.recentUserListCache.clear();
                                    RelationNTRecentListApiImpl.this.recentUserListCache.addAll(arrayList2);
                                    AnonymousClass1.this.f364662a.onResult(arrayList2);
                                    return;
                                }
                                QLog.e(RelationNTRecentListApiImpl.TAG, 1, "getRecentList is error! relation is invalid");
                                AnonymousClass1.this.f364662a.onResult(arrayList2);
                            }
                        }, 16, null, true);
                    }
                }
            });
        }
    }

    @Override // com.tencent.relation.common.api.IRelationNTRecentListApi
    public List<RecentUser> getRecentListFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new ArrayList(this.recentUserListCache);
    }

    @Override // com.tencent.relation.common.api.IRelationNTRecentListApi
    public ArrayList<Object> getRecentListFromCacheInObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new ArrayList<>(this.recentUserListCache);
    }
}
