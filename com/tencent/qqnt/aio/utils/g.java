package com.tencent.qqnt.aio.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0011J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006RB\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\r8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0010\u0010\u0011R0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/utils/g;", "", "", "chatType", "", "peerId", "", "peerUin", "", "a", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/aio/frame/b;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getMRightFrameProcessorMap$annotations", "()V", "mRightFrameProcessorMap", "c", "mRightFrameProcessorInstanceMap", "<init>", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f352296a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/drawer/Inject_aio_right_frame_support.yml", version = 1)
    @NotNull
    private static final HashMap<String, Class<com.tencent.qqnt.aio.frame.b>> mRightFrameProcessorMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, com.tencent.qqnt.aio.frame.b> mRightFrameProcessorInstanceMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47923);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f352296a = new g();
        HashMap<String, Class<com.tencent.qqnt.aio.frame.b>> hashMap = new HashMap<>();
        mRightFrameProcessorMap = hashMap;
        hashMap.put("2", com.tencent.mobileqq.activity.aio.helper.s.class);
        hashMap.put("1", com.tencent.mobileqq.activity.aio.helper.r.class);
        mRightFrameProcessorInstanceMap = new HashMap<>();
        ArrayList arrayList = new ArrayList(hashMap.size());
        for (Map.Entry<String, Class<com.tencent.qqnt.aio.frame.b>> entry : hashMap.entrySet()) {
            HashMap<String, com.tencent.qqnt.aio.frame.b> hashMap2 = mRightFrameProcessorInstanceMap;
            String key = entry.getKey();
            com.tencent.qqnt.aio.frame.b newInstance = entry.getValue().newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.aio.frame.IAIORightFrameSupportProcessor");
            arrayList.add(hashMap2.put(key, newInstance));
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(int chatType, @Nullable String peerId, long peerUin) {
        com.tencent.qqnt.aio.frame.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(chatType), peerId, Long.valueOf(peerUin))).booleanValue();
        }
        HashMap<String, com.tencent.qqnt.aio.frame.b> hashMap = mRightFrameProcessorInstanceMap;
        if (!hashMap.containsKey(String.valueOf(chatType)) || (bVar = hashMap.get(String.valueOf(chatType))) == null) {
            return false;
        }
        return bVar.a(peerId, peerUin);
    }
}
