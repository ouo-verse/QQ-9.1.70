package com.tencent.qqnt.chats.main.vm.datasource;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J2\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010 \u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J8\u0010%\u001a\u00020\u00042\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020!2\u001a\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010#0!H\u0016J(\u0010)\u001a\u00020\u00042\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010'\u001a\u00020\u00162\b\b\u0002\u0010(\u001a\u00020\u0002H\u0016J\u001a\u0010+\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u001d2\u0006\u0010*\u001a\u00020\u0016H\u0016J\u0012\u0010-\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010,H\u0016R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020/0.8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "", "", "c", "", OperateCustomButton.OPERATE_CREATE, "p", "destroy", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "getRecentContactList", "", "chatUid", "", "chatUin", "isTop", "", "contactType", "k", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "i", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contact", DomainData.DOMAIN_NAME, "f", "Lkotlin/Function1;", "opChanged", "", "opGetPayload", "l", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, com.tencent.luggage.wxa.c8.c.G, "loadNext", "e", "jumpType", "j", "Lcom/tencent/qqnt/chats/main/vm/datasource/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/chats/data/c;", "Lcom/tencent/qqnt/chats/data/b;", "o", "()Lcom/tencent/qqnt/chats/data/c;", "dataNotify", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface IRecentContactRepo {
    void a();

    boolean c();

    void create();

    @Nullable
    List<com.tencent.qqnt.chats.core.adapter.itemdata.g> d();

    void destroy();

    void e(@Nullable com.tencent.qqnt.chats.core.adapter.itemdata.g item, int pos, boolean loadNext);

    void f(@NotNull Contact peer, @Nullable IOperateCallback callback);

    void g(@NotNull Contact peer, @Nullable IOperateCallback callback);

    void getRecentContactList(@Nullable IOperateCallback callback);

    void h();

    void i(@NotNull Contact peer, @Nullable IOperateCallback callback);

    void j(@Nullable RecentContactInfo item, int jumpType);

    void k(@NotNull String chatUid, long chatUin, boolean isTop, int contactType, @Nullable IOperateCallback callback);

    void l(@NotNull Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean> opChanged, @NotNull Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Object[]> opGetPayload);

    void m();

    void n(@NotNull RecentContactInfo contact, @Nullable IOperateCallback callback);

    @NotNull
    com.tencent.qqnt.chats.data.c<com.tencent.qqnt.chats.data.b> o();

    void p();

    void q(@Nullable d callback);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        public static void a(@NotNull IRecentContactRepo iRecentContactRepo, @NotNull Contact peer, @Nullable IOperateCallback iOperateCallback) {
            Intrinsics.checkNotNullParameter(peer, "peer");
        }

        public static void c(@NotNull IRecentContactRepo iRecentContactRepo, @NotNull RecentContactInfo contact, @Nullable IOperateCallback iOperateCallback) {
            Intrinsics.checkNotNullParameter(contact, "contact");
        }

        @Nullable
        public static List<com.tencent.qqnt.chats.core.adapter.itemdata.g> e(@NotNull IRecentContactRepo iRecentContactRepo) {
            List<com.tencent.qqnt.chats.core.adapter.itemdata.g> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        public static void g(@NotNull IRecentContactRepo iRecentContactRepo) {
            iRecentContactRepo.a();
        }

        public static boolean h(@NotNull IRecentContactRepo iRecentContactRepo) {
            return false;
        }

        public static void k(@NotNull IRecentContactRepo iRecentContactRepo, @NotNull Contact peer, @Nullable IOperateCallback iOperateCallback) {
            Intrinsics.checkNotNullParameter(peer, "peer");
        }

        public static void l(@NotNull IRecentContactRepo iRecentContactRepo, @NotNull Contact peer, @Nullable IOperateCallback iOperateCallback) {
            Intrinsics.checkNotNullParameter(peer, "peer");
        }

        public static void m(@NotNull IRecentContactRepo iRecentContactRepo, @NotNull Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean> opChanged, @NotNull Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Object[]> opGetPayload) {
            Intrinsics.checkNotNullParameter(opChanged, "opChanged");
            Intrinsics.checkNotNullParameter(opGetPayload, "opGetPayload");
        }

        public static void q(@NotNull IRecentContactRepo iRecentContactRepo, @NotNull String chatUid, long j3, boolean z16, int i3, @Nullable IOperateCallback iOperateCallback) {
            Intrinsics.checkNotNullParameter(chatUid, "chatUid");
        }

        public static void b(@NotNull IRecentContactRepo iRecentContactRepo) {
        }

        public static void d(@NotNull IRecentContactRepo iRecentContactRepo) {
        }

        public static void f(@NotNull IRecentContactRepo iRecentContactRepo) {
        }

        public static void n(@NotNull IRecentContactRepo iRecentContactRepo) {
        }

        public static void o(@NotNull IRecentContactRepo iRecentContactRepo) {
        }

        public static void p(@NotNull IRecentContactRepo iRecentContactRepo, @Nullable d dVar) {
        }

        public static void i(@NotNull IRecentContactRepo iRecentContactRepo, @Nullable RecentContactInfo recentContactInfo, int i3) {
        }

        public static void j(@NotNull IRecentContactRepo iRecentContactRepo, @Nullable com.tencent.qqnt.chats.core.adapter.itemdata.g gVar, int i3, boolean z16) {
        }
    }
}
