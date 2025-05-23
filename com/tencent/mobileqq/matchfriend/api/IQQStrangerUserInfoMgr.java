package com.tencent.mobileqq.matchfriend.api;

import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0004H&J\b\u0010\u0014\u001a\u00020\u0004H&J9\u0010\u0019\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2'\b\u0002\u0010\u0018\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H&JC\u0010\u001d\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a2+\b\u0002\u0010\u0018\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u001a\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/api/IQQStrangerUserInfoMgr;", "Lmqq/app/api/IRuntimeService;", "Lcom/tencent/mobileqq/matchfriend/api/d;", "listener", "", "addUserInfoListener", "removeUserInfoListener", "Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo;", "getSelfUserInfo", ITVKPlayerEventListener.KEY_USER_INFO, "setSelfUserInfo", "Lcom/tencent/mobileqq/matchfriend/bean/c;", "contact", "getUserInfo", "", "chatType", "", "tinyId", "deleteUserInfo", "deleteAll", "preLoad", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cb", "reqUserInfo", "", "contacts", "userinfoList", "batchReqUserInfo", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface IQQStrangerUserInfoMgr extends IRuntimeService {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr, List list, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    function1 = null;
                }
                iQQStrangerUserInfoMgr.batchReqUserInfo(list, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: batchReqUserInfo");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr, com.tencent.mobileqq.matchfriend.bean.c cVar, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    function1 = null;
                }
                iQQStrangerUserInfoMgr.reqUserInfo(cVar, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reqUserInfo");
        }
    }

    void addUserInfoListener(@NotNull d listener);

    void batchReqUserInfo(@NotNull List<com.tencent.mobileqq.matchfriend.bean.c> contacts, @Nullable Function1<? super List<QQStrangerUserInfo>, Unit> cb5);

    void deleteAll();

    void deleteUserInfo(int chatType, long tinyId);

    @Nullable
    QQStrangerUserInfo getSelfUserInfo();

    @Nullable
    QQStrangerUserInfo getUserInfo(@NotNull com.tencent.mobileqq.matchfriend.bean.c contact);

    void preLoad();

    void removeUserInfoListener(@NotNull d listener);

    void reqUserInfo(@NotNull com.tencent.mobileqq.matchfriend.bean.c contact, @Nullable Function1<? super QQStrangerUserInfo, Unit> cb5);

    void setSelfUserInfo(@Nullable QQStrangerUserInfo userInfo);
}
