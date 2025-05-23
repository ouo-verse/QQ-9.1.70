package com.tencent.mobileqq.matchfriend.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.matchfriend.reborn.userinfo.QQStrangerUserInfoRepository;
import com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerDispatchers;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J7\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102%\u0010\u001d\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001aH\u0016JA\u0010\"\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u001f2)\u0010\u001d\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u001f\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001aH\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010*\u001a\u00020)8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/api/impl/QQStrangerUserInfoMgrImpl;", "Lcom/tencent/mobileqq/matchfriend/api/IQQStrangerUserInfoMgr;", "Lkotlinx/coroutines/CoroutineScope;", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/matchfriend/api/d;", "listener", "addUserInfoListener", "removeUserInfoListener", "Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo;", "getSelfUserInfo", ITVKPlayerEventListener.KEY_USER_INFO, "setSelfUserInfo", "Lcom/tencent/mobileqq/matchfriend/bean/c;", "contact", "getUserInfo", "", "chatType", "", "tinyId", "deleteUserInfo", "deleteAll", "preLoad", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cb", "reqUserInfo", "", "contacts", "userinfoList", "batchReqUserInfo", "Lcom/tencent/mobileqq/matchfriend/reborn/userinfo/QQStrangerUserInfoRepository;", "repo", "Lcom/tencent/mobileqq/matchfriend/reborn/userinfo/QQStrangerUserInfoRepository;", "", "userInfoChangeListeners", "Ljava/util/List;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "<init>", "()V", "Companion", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerUserInfoMgrImpl implements IQQStrangerUserInfoMgr, CoroutineScope {
    private static final int GET_USER_INFO_MAX_NUM = 50;
    private static final String TAG = "QQStrangerUserInfoMgrImpl";
    private QQStrangerUserInfoRepository repo;
    private final List<com.tencent.mobileqq.matchfriend.api.d> userInfoChangeListeners = new ArrayList();
    private final CoroutineContext coroutineContext = QQStrangerDispatchers.f245457a.a().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new b(CoroutineExceptionHandler.INSTANCE));

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext context, Throwable exception) {
            QLog.e(QQStrangerUserInfoMgrImpl.TAG, 1, "error in Coroutine. ctx=" + context, exception);
            if (AppSetting.isDebugVersion()) {
                throw exception;
            }
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr
    public void addUserInfoListener(com.tencent.mobileqq.matchfriend.api.d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.userInfoChangeListeners.contains(listener)) {
            return;
        }
        this.userInfoChangeListeners.add(listener);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr
    public void batchReqUserInfo(List<com.tencent.mobileqq.matchfriend.bean.c> contacts, Function1<? super List<QQStrangerUserInfo>, Unit> cb5) {
        Intrinsics.checkNotNullParameter(contacts, "contacts");
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new QQStrangerUserInfoMgrImpl$batchReqUserInfo$1(contacts, cb5, this, null), 3, null);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr
    public void deleteAll() {
        QQStrangerUserInfoRepository qQStrangerUserInfoRepository = this.repo;
        if (qQStrangerUserInfoRepository != null) {
            qQStrangerUserInfoRepository.f();
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr
    public void deleteUserInfo(int chatType, long tinyId) {
        QQStrangerUserInfoRepository qQStrangerUserInfoRepository = this.repo;
        if (qQStrangerUserInfoRepository != null) {
            qQStrangerUserInfoRepository.h(chatType, tinyId);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr
    public QQStrangerUserInfo getSelfUserInfo() {
        QQStrangerUserInfoRepository qQStrangerUserInfoRepository = this.repo;
        if (qQStrangerUserInfoRepository != null) {
            return qQStrangerUserInfoRepository.k();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr
    public QQStrangerUserInfo getUserInfo(com.tencent.mobileqq.matchfriend.bean.c contact) {
        QQStrangerUserInfoRepository qQStrangerUserInfoRepository;
        Intrinsics.checkNotNullParameter(contact, "contact");
        if (contact.c() != 0) {
            QQStrangerUserInfoRepository qQStrangerUserInfoRepository2 = this.repo;
            if (qQStrangerUserInfoRepository2 != null) {
                return qQStrangerUserInfoRepository2.n(contact.a(), contact.c());
            }
            return null;
        }
        if (!(contact.b().length() > 0) || (qQStrangerUserInfoRepository = this.repo) == null) {
            return null;
        }
        return qQStrangerUserInfoRepository.m(contact.a(), contact.b());
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.repo = new QQStrangerUserInfoRepository(appRuntime);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr
    public void preLoad() {
        QQStrangerUserInfoRepository qQStrangerUserInfoRepository = this.repo;
        if (qQStrangerUserInfoRepository != null) {
            qQStrangerUserInfoRepository.o();
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr
    public void removeUserInfoListener(com.tencent.mobileqq.matchfriend.api.d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.userInfoChangeListeners.contains(listener)) {
            this.userInfoChangeListeners.remove(listener);
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr
    public void reqUserInfo(com.tencent.mobileqq.matchfriend.bean.c contact, final Function1<? super QQStrangerUserInfo, Unit> cb5) {
        List<com.tencent.mobileqq.matchfriend.bean.c> listOf;
        Intrinsics.checkNotNullParameter(contact, "contact");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(contact);
        batchReqUserInfo(listOf, new Function1<List<? extends QQStrangerUserInfo>, Unit>() { // from class: com.tencent.mobileqq.matchfriend.api.impl.QQStrangerUserInfoMgrImpl$reqUserInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends QQStrangerUserInfo> list) {
                invoke2((List<QQStrangerUserInfo>) list);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<QQStrangerUserInfo> it) {
                Object orNull;
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<QQStrangerUserInfo, Unit> function1 = cb5;
                if (function1 != 0) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(it, 0);
                    function1.invoke(orNull);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr
    public void setSelfUserInfo(QQStrangerUserInfo userInfo) {
        QQStrangerUserInfoRepository qQStrangerUserInfoRepository = this.repo;
        if (qQStrangerUserInfoRepository != null) {
            qQStrangerUserInfoRepository.q(userInfo);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        QQStrangerUserInfoRepository qQStrangerUserInfoRepository = this.repo;
        if (qQStrangerUserInfoRepository != null) {
            qQStrangerUserInfoRepository.j();
        }
        this.repo = null;
    }
}
