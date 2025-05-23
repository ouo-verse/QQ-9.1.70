package com.tencent.mobileqq.guild.media.core;

import com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper;
import com.tencent.mobileqq.guild.media.core.logic.InviteOpenMicConfigHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelFreeGiftTaskHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelMicSequenceHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelMultiRoomHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelPermissionHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelShareLoadInfoHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelSpeakerHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelThirdAppHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelUserListRequestHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaEnterExitRequestHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaQQAccountStateHelper;
import com.tencent.mobileqq.guild.media.core.logic.ScreenShareStatusHelper;
import com.tencent.mobileqq.guild.media.core.logic.ab;
import com.tencent.mobileqq.guild.media.core.logic.ac;
import com.tencent.mobileqq.guild.media.core.logic.ad;
import com.tencent.mobileqq.guild.media.core.logic.ae;
import com.tencent.mobileqq.guild.media.core.logic.af;
import com.tencent.mobileqq.guild.media.core.logic.be;
import com.tencent.mobileqq.guild.media.core.logic.bh;
import com.tencent.mobileqq.guild.media.core.logic.bi;
import com.tencent.mobileqq.guild.media.core.logic.bj;
import com.tencent.mobileqq.guild.media.core.logic.bz;
import com.tencent.mobileqq.guild.media.core.logic.cd;
import com.tencent.mobileqq.guild.media.core.logic.ce;
import com.tencent.mobileqq.guild.media.core.logic.cf;
import com.tencent.mobileqq.guild.media.core.logic.gift.MediaGiftService;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.guild.media.core.logic.trtc.TRTCAudioRoomLocalNew;
import com.vivo.push.PushClientConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J!\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016RG\u0010\u0018\u001a2\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010j\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011`\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b\u001a\u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/MediaChannelLogicHub;", "Lcom/tencent/mobileqq/guild/media/core/g;", "T", "Ljava/lang/Class;", PushClientConstants.TAG_CLASS_NAME, "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/media/core/MediaBusinessType;", "businessType", "Lcom/tencent/mobileqq/guild/media/core/d;", "f", "", "E0", "p", "h0", "u", "Ljava/util/HashMap;", "Lkotlin/Lazy;", "", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "getMediaRoomHelpersMap", "()Ljava/util/HashMap;", "mediaRoomHelpersMap", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaQQAccountStateHelper;", "e", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaQQAccountStateHelper;", "g", "()Lcom/tencent/mobileqq/guild/media/core/logic/MediaQQAccountStateHelper;", "qqAccountStateHelper", "", "Lkotlin/Lazy;", "()Ljava/util/List;", "businessHelperList", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelLogicHub implements g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Class<?>, Lazy<Object>> mediaRoomHelpersMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaQQAccountStateHelper qqAccountStateHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy businessHelperList;

    public MediaChannelLogicHub(@NotNull final f core) {
        Lazy<Object> lazy;
        Lazy<Object> lazy2;
        Lazy<Object> lazy3;
        Lazy<Object> lazy4;
        Lazy<Object> lazy5;
        Lazy<Object> lazy6;
        Lazy<Object> lazy7;
        Lazy<Object> lazy8;
        Lazy<Object> lazy9;
        Lazy<Object> lazy10;
        Lazy<Object> lazy11;
        Lazy<Object> lazy12;
        Lazy<Object> lazy13;
        Lazy<Object> lazy14;
        Lazy<Object> lazy15;
        Lazy<Object> lazy16;
        Lazy<Object> lazy17;
        Lazy<Object> lazy18;
        Lazy<Object> lazy19;
        Lazy<Object> lazy20;
        Lazy<Object> lazy21;
        Lazy<Object> lazy22;
        Lazy<Object> lazy23;
        Lazy<Object> lazy24;
        Lazy<Object> lazy25;
        Lazy<Object> lazy26;
        Lazy<Object> lazy27;
        Lazy<Object> lazy28;
        Lazy<Object> lazy29;
        Lazy<Object> lazy30;
        Lazy<Object> lazy31;
        Lazy<Object> lazy32;
        Lazy lazy33;
        Intrinsics.checkNotNullParameter(core, "core");
        HashMap<Class<?>, Lazy<Object>> hashMap = new HashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ts1.a>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ts1.a invoke() {
                return new ts1.a(f.this);
            }
        });
        hashMap.put(ts1.a.class, lazy);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MediaEnterExitRequestHelper>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaEnterExitRequestHelper invoke() {
                return new MediaEnterExitRequestHelper(f.this);
            }
        });
        hashMap.put(com.tencent.mobileqq.guild.media.core.logic.r.class, lazy2);
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<cd>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final cd invoke() {
                return new cd(f.this);
            }
        });
        hashMap.put(cd.class, lazy3);
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ys1.e>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ys1.e invoke() {
                return new ys1.e(f.this);
            }
        });
        hashMap.put(ys1.e.class, lazy4);
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<MediaChannelUserListRequestHelper>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaChannelUserListRequestHelper invoke() {
                return new MediaChannelUserListRequestHelper(f.this);
            }
        });
        hashMap.put(com.tencent.mobileqq.guild.media.core.logic.q.class, lazy5);
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.media.core.logic.g>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.media.core.logic.g invoke() {
                return new com.tencent.mobileqq.guild.media.core.logic.g(f.this);
            }
        });
        hashMap.put(com.tencent.mobileqq.guild.media.core.logic.g.class, lazy6);
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<ScreenShareStatusHelper>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ScreenShareStatusHelper invoke() {
                return new ScreenShareStatusHelper(f.this);
            }
        });
        hashMap.put(ScreenShareStatusHelper.class, lazy7);
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<MediaChannelPermissionHelper>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaChannelPermissionHelper invoke() {
                return new MediaChannelPermissionHelper(f.this);
            }
        });
        hashMap.put(MediaChannelPermissionHelper.class, lazy8);
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<ae>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ae invoke() {
                return new ae(f.this);
            }
        });
        hashMap.put(ae.class, lazy9);
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<cf>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$10
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final cf invoke() {
                return new cf(f.this);
            }
        });
        hashMap.put(cf.class, lazy10);
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<ScreenShareStatusHelper>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$11
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ScreenShareStatusHelper invoke() {
                return new ScreenShareStatusHelper(f.this);
            }
        });
        hashMap.put(ScreenShareStatusHelper.class, lazy11);
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<bz>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$12
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final bz invoke() {
                return new bz(f.this);
            }
        });
        hashMap.put(bz.class, lazy12);
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<ScreenShareStatusHelper>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$13
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ScreenShareStatusHelper invoke() {
                return new ScreenShareStatusHelper(f.this);
            }
        });
        hashMap.put(ScreenShareStatusHelper.class, lazy13);
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<ab>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$14
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ab invoke() {
                return new ab(TRTCAudioRoomLocalNew.INSTANCE.a(), f.this);
            }
        });
        hashMap.put(ab.class, lazy14);
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<InviteOpenMicConfigHelper>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$15
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final InviteOpenMicConfigHelper invoke() {
                return new InviteOpenMicConfigHelper(f.this);
            }
        });
        hashMap.put(InviteOpenMicConfigHelper.class, lazy15);
        lazy16 = LazyKt__LazyJVMKt.lazy(new Function0<us1.c>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$16
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final us1.c invoke() {
                return new us1.c(f.this);
            }
        });
        hashMap.put(us1.b.class, lazy16);
        lazy17 = LazyKt__LazyJVMKt.lazy(new Function0<MediaChannelMultiRoomHelper>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$17
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaChannelMultiRoomHelper invoke() {
                return new MediaChannelMultiRoomHelper(f.this);
            }
        });
        hashMap.put(MediaChannelMultiRoomHelper.class, lazy17);
        lazy18 = LazyKt__LazyJVMKt.lazy(new Function0<MediaGiftService>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$18
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaGiftService invoke() {
                return new MediaGiftService(f.this);
            }
        });
        hashMap.put(com.tencent.mobileqq.guild.media.core.logic.gift.a.class, lazy18);
        lazy19 = LazyKt__LazyJVMKt.lazy(new Function0<bi>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$19
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final bi invoke() {
                return new bi(f.this);
            }
        });
        hashMap.put(bi.class, lazy19);
        lazy20 = LazyKt__LazyJVMKt.lazy(new Function0<bh>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$20
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final bh invoke() {
                return new bh(f.this);
            }
        });
        hashMap.put(bh.class, lazy20);
        lazy21 = LazyKt__LazyJVMKt.lazy(new Function0<MediaChannelFreeGiftTaskHelper>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$21
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaChannelFreeGiftTaskHelper invoke() {
                return new MediaChannelFreeGiftTaskHelper(f.this);
            }
        });
        hashMap.put(MediaChannelFreeGiftTaskHelper.class, lazy21);
        lazy22 = LazyKt__LazyJVMKt.lazy(new Function0<be>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$22
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final be invoke() {
                return new be(f.this);
            }
        });
        hashMap.put(com.tencent.mobileqq.guild.media.core.logic.gift.b.class, lazy22);
        lazy23 = LazyKt__LazyJVMKt.lazy(new Function0<ad>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$23
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ad invoke() {
                List e16;
                f fVar = f.this;
                e16 = this.e();
                return new ad(fVar, e16);
            }
        });
        hashMap.put(ad.class, lazy23);
        lazy24 = LazyKt__LazyJVMKt.lazy(new Function0<MediaChannelShareLoadInfoHelper>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$24
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaChannelShareLoadInfoHelper invoke() {
                return new MediaChannelShareLoadInfoHelper(f.this);
            }
        });
        hashMap.put(MediaChannelShareLoadInfoHelper.class, lazy24);
        lazy25 = LazyKt__LazyJVMKt.lazy(new Function0<MediaChannelSpeakerHelper>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$25
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaChannelSpeakerHelper invoke() {
                return new MediaChannelSpeakerHelper(f.this);
            }
        });
        hashMap.put(com.tencent.mobileqq.guild.media.core.logic.o.class, lazy25);
        lazy26 = LazyKt__LazyJVMKt.lazy(new Function0<ce>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$26
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ce invoke() {
                return new ce(f.this);
            }
        });
        hashMap.put(com.tencent.mobileqq.guild.media.core.logic.s.class, lazy26);
        lazy27 = LazyKt__LazyJVMKt.lazy(new Function0<TRTCAudioRoomLocalNew>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$27
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TRTCAudioRoomLocalNew invoke() {
                return TRTCAudioRoomLocalNew.INSTANCE.a();
            }
        });
        hashMap.put(ITRTCAudioRoom.class, lazy27);
        lazy28 = LazyKt__LazyJVMKt.lazy(new Function0<af>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$28
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final af invoke() {
                return new af();
            }
        });
        hashMap.put(com.tencent.mobileqq.guild.media.core.logic.n.class, lazy28);
        lazy29 = LazyKt__LazyJVMKt.lazy(new Function0<bj>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$29
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final bj invoke() {
                return new bj(f.this);
            }
        });
        hashMap.put(com.tencent.mobileqq.guild.media.core.logic.p.class, lazy29);
        lazy30 = LazyKt__LazyJVMKt.lazy(new Function0<AudioNotifyHelper>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$30
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AudioNotifyHelper invoke() {
                return new AudioNotifyHelper();
            }
        });
        hashMap.put(AudioNotifyHelper.class, lazy30);
        lazy31 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.media.core.logic.a>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$31
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.media.core.logic.a invoke() {
                return new com.tencent.mobileqq.guild.media.core.logic.a();
            }
        });
        hashMap.put(com.tencent.mobileqq.guild.media.core.logic.a.class, lazy31);
        lazy32 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.media.core.logic.b>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$mediaRoomHelpersMap$1$32
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.media.core.logic.b invoke() {
                return new com.tencent.mobileqq.guild.media.core.logic.b(f.this);
            }
        });
        hashMap.put(com.tencent.mobileqq.guild.media.core.logic.b.class, lazy32);
        this.mediaRoomHelpersMap = hashMap;
        this.qqAccountStateHelper = new MediaQQAccountStateHelper(new WeakReference(core));
        lazy33 = LazyKt__LazyJVMKt.lazy(new Function0<List<d>>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelLogicHub$businessHelperList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<d> invoke() {
                ArrayList arrayList = new ArrayList();
                f fVar = f.this;
                arrayList.add(new MediaChannelRaiseHandHelper(fVar));
                arrayList.add(new ac(fVar));
                arrayList.add(new MediaChannelMicSequenceHelper(fVar));
                arrayList.add(new MediaChannelThirdAppHelper(fVar));
                return arrayList;
            }
        });
        this.businessHelperList = lazy33;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<d> e() {
        return (List) this.businessHelperList.getValue();
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        g gVar;
        Collection<Lazy<Object>> values = this.mediaRoomHelpersMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "mediaRoomHelpersMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Object value = ((Lazy) it.next()).getValue();
            if (value instanceof g) {
                gVar = (g) value;
            } else {
                gVar = null;
            }
            if (gVar != null) {
                gVar.E0();
            }
        }
    }

    public final <T> T b(@NotNull Class<T> className) {
        Intrinsics.checkNotNullParameter(className, "className");
        Lazy<Object> lazy = this.mediaRoomHelpersMap.get(className);
        if (lazy != null) {
            return (T) lazy.getValue();
        }
        return null;
    }

    @NotNull
    public final d f(@NotNull MediaBusinessType businessType) {
        boolean z16;
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        for (d dVar : e()) {
            if (dVar.O() == businessType) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return dVar;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final MediaQQAccountStateHelper getQqAccountStateHelper() {
        return this.qqAccountStateHelper;
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void h0() {
        g gVar;
        Collection<Lazy<Object>> values = this.mediaRoomHelpersMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "mediaRoomHelpersMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Object value = ((Lazy) it.next()).getValue();
            if (value instanceof g) {
                gVar = (g) value;
            } else {
                gVar = null;
            }
            if (gVar != null) {
                gVar.h0();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void p() {
        g gVar;
        Collection<Lazy<Object>> values = this.mediaRoomHelpersMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "mediaRoomHelpersMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Object value = ((Lazy) it.next()).getValue();
            if (value instanceof g) {
                gVar = (g) value;
            } else {
                gVar = null;
            }
            if (gVar != null) {
                gVar.p();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void u() {
        g gVar;
        Collection<Lazy<Object>> values = this.mediaRoomHelpersMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "mediaRoomHelpersMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Object value = ((Lazy) it.next()).getValue();
            if (value instanceof g) {
                gVar = (g) value;
            } else {
                gVar = null;
            }
            if (gVar != null) {
                gVar.u();
            }
        }
    }
}
