package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/flutter/channel/chat/a;", "Lug2/a;", "", "b", "", "c", "", "a", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/chat/ExpandConversation;", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/chat/ExpandConversation;", "conv", "<init>", "(Lcom/tencent/mobileqq/qqexpand/flutter/channel/chat/ExpandConversation;)V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a implements ug2.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ExpandConversation conv;

    public a(ExpandConversation conv) {
        Intrinsics.checkNotNullParameter(conv, "conv");
        this.conv = conv;
    }

    @Override // ug2.a
    public int a() {
        return this.conv.uinType;
    }

    @Override // ug2.a
    public long b() {
        ULong uLongOrNull;
        String str = this.conv.peerUin;
        if (str == null || (uLongOrNull = UStringsKt.toULongOrNull(str)) == null) {
            return 0L;
        }
        return uLongOrNull.getData();
    }

    @Override // ug2.a
    public String c() {
        return this.conv.nickName;
    }
}
