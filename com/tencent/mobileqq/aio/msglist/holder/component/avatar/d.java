package com.tencent.mobileqq.aio.msglist.holder.component.avatar;

import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.aio.msglist.holder.f;
import com.tencent.mobileqq.aio.widget.CommonImageView;
import com.tencent.mobileqq.matchfriend.nt.MatchFriendAIOAvatarProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006RB\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nj\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f`\u000e8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\u000f\u0012\u0004\b\u0010\u0010\u0011R0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/avatar/d;", "", "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/mobileqq/aio/widget/CommonImageView;", "avatarView", "", "b", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/msglist/holder/f;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getMAvatarProcessorMap$annotations", "()V", "mAvatarProcessorMap", "c", "mAvatarProcessorInstanceMap", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f190716a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/msg/Inject_AIO_Avatar_Processor.yml", version = 1)
    @NotNull
    private static final HashMap<String, Class<f>> mAvatarProcessorMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, f> mAvatarProcessorInstanceMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60135);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f190716a = new d();
        HashMap<String, Class<f>> hashMap = new HashMap<>();
        mAvatarProcessorMap = hashMap;
        hashMap.put("8", com.dataline.nt.b.class);
        hashMap.put("119", ba2.e.class);
        hashMap.put("105", jd1.b.class);
        hashMap.put("104", MatchFriendAIOAvatarProcessor.class);
        mAvatarProcessorInstanceMap = new HashMap<>();
        ArrayList arrayList = new ArrayList(hashMap.size());
        for (Map.Entry<String, Class<f>> entry : hashMap.entrySet()) {
            HashMap<String, f> hashMap2 = mAvatarProcessorInstanceMap;
            String key = entry.getKey();
            f newInstance = entry.getValue().newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.holder.IAIOAvatarProcessor");
            arrayList.add(hashMap2.put(key, newInstance));
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @WorkerThread
    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public final boolean b(@NotNull MsgRecord msgRecord, @NotNull CommonImageView avatarView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgRecord, (Object) avatarView)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        String valueOf = String.valueOf(msgRecord.chatType);
        HashMap<String, f> hashMap = mAvatarProcessorInstanceMap;
        if (!hashMap.containsKey(valueOf)) {
            return false;
        }
        f fVar = hashMap.get(valueOf);
        Intrinsics.checkNotNull(fVar);
        fVar.a(avatarView, msgRecord);
        return true;
    }
}
