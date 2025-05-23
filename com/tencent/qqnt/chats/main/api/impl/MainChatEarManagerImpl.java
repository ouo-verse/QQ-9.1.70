package com.tencent.qqnt.chats.main.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.ui.third.p013const.RelativeEnum;
import com.tencent.qqnt.chats.core.ui.third.p013const.ThirdViewEnum;
import com.tencent.qqnt.chats.main.api.IMainChatEarManager;
import com.tencent.qqnt.chats.utils.f;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.SpecificEventTypeInfoInMsgBox;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J \u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\"\u0010\u000b\u001a\u00020\n2\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\r\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u001e\u0010\u0013\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J&\u0010\u0014\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R$\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R,\u0010&\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/chats/main/api/impl/MainChatEarManagerImpl;", "Lcom/tencent/qqnt/chats/main/api/IMainChatEarManager;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "earList", "unParse", "Lcom/tencent/qqnt/kernel/nativeinterface/SpecificEventTypeInfoInMsgBox;", "list", "", "type", "", "isExistEventType", "target", "findNextIndex", "Lcom/tencent/qqnt/kernel/api/aa;", "getService", "Lkotlin/Function1;", "", "callback", "setNextCallback", "setOnLittleEarChangeCallback", "onLitterEarChange", "getCurItem", "getNextItem", "notify", "moveToNext", "hasLittleEar", "Lcom/tencent/qqnt/chats/core/ui/third/f;", "buildLittleParam", "Lcom/tencent/qqnt/chats/main/api/IMainChatEarManager$a;", "getParseInfo", "fetchEarChatList", "curEarItem", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "curEarList", "Ljava/util/List;", "nextCallback", "Lkotlin/jvm/functions/Function1;", "onLittleEarChangeCallback", "parseInfo", "Lcom/tencent/qqnt/chats/main/api/IMainChatEarManager$a;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MainChatEarManagerImpl implements IMainChatEarManager {
    static IPatchRedirector $redirector_;

    @Nullable
    private RecentContactInfo curEarItem;

    @Nullable
    private List<RecentContactInfo> curEarList;

    @Nullable
    private Function1<? super RecentContactInfo, Unit> nextCallback;

    @Nullable
    private Function1<? super List<RecentContactInfo>, Unit> onLittleEarChangeCallback;

    @Nullable
    private IMainChatEarManager.a parseInfo;

    public MainChatEarManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int findNextIndex(List<RecentContactInfo> list, RecentContactInfo target) {
        if (target == null || list.size() <= 1) {
            return 0;
        }
        Iterator<RecentContactInfo> it = list.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (f.f355547a.c(it.next(), target)) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        return Math.max(i3 + 1, 0) % list.size();
    }

    private final aa getService() {
        IKernelService i3 = com.tencent.qqnt.msg.f.i();
        if (i3 != null) {
            return i3.getRecentContactService();
        }
        return null;
    }

    private final boolean isExistEventType(List<SpecificEventTypeInfoInMsgBox> list, int type) {
        Object obj;
        boolean z16;
        if (list == null) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                SpecificEventTypeInfoInMsgBox specificEventTypeInfoInMsgBox = (SpecificEventTypeInfoInMsgBox) obj;
                if (specificEventTypeInfoInMsgBox != null && specificEventTypeInfoInMsgBox.eventTypeInMsgBox == type) {
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
        if (obj == null) {
            return false;
        }
        return true;
    }

    private final List<RecentContactInfo> unParse(List<RecentContactInfo> earList) {
        boolean z16;
        List<RecentContactInfo> mutableList;
        if (!com.tencent.qqnt.classadapter.a.a()) {
            this.parseInfo = null;
            QLog.d("MsgExt", 1, "[onLitterEarChange#unParse] parse : care bar setting is false");
            return null;
        }
        List<RecentContactInfo> list = earList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
            Iterator<RecentContactInfo> it = mutableList.iterator();
            int i3 = 0;
            int i16 = 0;
            while (it.hasNext()) {
                RecentContactInfo next = it.next();
                if (isExistEventType(next.listOfSpecificEventTypeInfosInMsgBox, 1006)) {
                    i3++;
                } else if (isExistEventType(next.listOfSpecificEventTypeInfosInMsgBox, 2006)) {
                    i16++;
                } else {
                    it.remove();
                }
            }
            if (!mutableList.isEmpty()) {
                this.parseInfo = new IMainChatEarManager.a(i3, i16);
                this.curEarItem = mutableList.get(0);
            }
            QLog.d("MsgExt", 1, "[onLitterEarChange#unParse] parse : beforeSize=" + earList.size() + ", afterSize=" + mutableList.size() + ", spCnt=" + i3 + ", keyCnt=" + i16);
            return mutableList;
        }
        this.parseInfo = null;
        QLog.d("MsgExt", 1, "[onLitterEarChange#unParse] parse : ear null or empty");
        return null;
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatEarManager
    @NotNull
    public com.tencent.qqnt.chats.core.ui.third.f buildLittleParam() {
        Map emptyMap;
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.qqnt.chats.core.ui.third.f) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        ThirdViewEnum thirdViewEnum = ThirdViewEnum.LITTLE_EAR;
        emptyMap = MapsKt__MapsKt.emptyMap();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new RelativeEnum[]{RelativeEnum.TopToBannerBottom, RelativeEnum.EndToParentEnd});
        return new com.tencent.qqnt.chats.core.ui.third.f(thirdViewEnum, emptyMap, listOf, null, 8, null);
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatEarManager
    public void fetchEarChatList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        aa service = getService();
        if (service != null) {
            aa.b.a(service, new AnchorPointContactInfo(), true, 6, 0, null, 24, null);
        }
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatEarManager
    @Nullable
    public RecentContactInfo getCurItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RecentContactInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.curEarItem;
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatEarManager
    @Nullable
    public RecentContactInfo getNextItem() {
        Object orNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RecentContactInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        List<RecentContactInfo> list = this.curEarList;
        if (list != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(list, findNextIndex(list, this.curEarItem));
            return (RecentContactInfo) orNull;
        }
        return null;
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatEarManager
    @Nullable
    public IMainChatEarManager.a getParseInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (IMainChatEarManager.a) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.parseInfo;
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatEarManager
    public boolean hasLittleEar() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        List<RecentContactInfo> list = this.curEarList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatEarManager
    public boolean moveToNext(boolean notify) {
        Function1<? super RecentContactInfo, Unit> function1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, notify)).booleanValue();
        }
        RecentContactInfo nextItem = getNextItem();
        this.curEarItem = nextItem;
        if (nextItem != null && notify && (function1 = this.nextCallback) != null) {
            function1.invoke(nextItem);
            return true;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatEarManager
    public void onLitterEarChange() {
        List<RecentContactInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        aa service = getService();
        if (service != null) {
            list = service.M(6);
        } else {
            list = null;
        }
        List<RecentContactInfo> unParse = unParse(list);
        this.curEarList = unParse;
        Function1<? super List<RecentContactInfo>, Unit> function1 = this.onLittleEarChangeCallback;
        if (function1 != null) {
            function1.invoke(unParse);
        }
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatEarManager
    public void setNextCallback(@Nullable Function1<? super RecentContactInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
        } else {
            this.nextCallback = callback;
        }
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatEarManager
    public void setOnLittleEarChangeCallback(@Nullable Function1<? super List<RecentContactInfo>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
        } else {
            this.onLittleEarChangeCallback = callback;
        }
    }
}
