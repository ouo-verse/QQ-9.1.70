package kr1;

import com.tencent.mobileqq.guild.message.lastmsg.api.impl.d;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lkr1/a;", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstract;", "msgAbstract", "Lcv1/a;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f412901a = new a();

    a() {
    }

    @JvmStatic
    @NotNull
    public static final cv1.a a(@NotNull MsgAbstract msgAbstract) {
        Intrinsics.checkNotNullParameter(msgAbstract, "msgAbstract");
        cv1.a aVar = new cv1.a();
        aVar.d(d.d(msgAbstract));
        aVar.h(new QQText(aVar.a(), 3, 14));
        aVar.g(msgAbstract.msgType);
        aVar.f(msgAbstract.abstractTime);
        return aVar;
    }
}
