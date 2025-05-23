package com.tencent.mobileqq.emoticon.rare;

import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticon.rare.config.c;
import com.tencent.mobileqq.emoticon.rare.config.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.PullMomentType;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bR8\u0010\u0013\u001a&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00020\u0002 \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00110\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/emoticon/rare/a;", "", "", "serviceId", "", "c", "", "e", "", "b", "d", "isSelf", "triggerServiceId", "resultId", "a", "", "kotlin.jvm.PlatformType", "", "Ljava/util/Set;", "mmkvServiceIdList", "Ljava/lang/String;", "mCurrentUin", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f204862a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Set<Integer> mmkvServiceIdList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mCurrentUin;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33069);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f204862a = new a();
        mmkvServiceIdList = Collections.newSetFromMap(new ConcurrentHashMap());
        mCurrentUin = "";
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String b(int serviceId) {
        return "RARE_CONFIG_FETCHED_KEY_" + serviceId + "_" + mCurrentUin;
    }

    private final boolean c(int serviceId) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return fromV2.getBoolean(b(serviceId), false);
    }

    private final void d() {
        String str;
        AppRuntime peekAppRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (!Intrinsics.areEqual(mCurrentUin, str)) {
            QLog.i("RareConfigFetchHelper", 1, "reset cache " + mCurrentUin + " -> " + str);
            mCurrentUin = str;
            mmkvServiceIdList.clear();
        }
    }

    private final void e(int serviceId) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        fromV2.putBoolean(b(serviceId), true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(boolean isSelf, int triggerServiceId, @NotNull String resultId) {
        d d16;
        Integer intOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSelf), Integer.valueOf(triggerServiceId), resultId);
            return;
        }
        Intrinsics.checkNotNullParameter(resultId, "resultId");
        if (!isSelf) {
            return;
        }
        c cVar = c.f204869a;
        if (cVar.g() && (d16 = cVar.b().d(String.valueOf(triggerServiceId), resultId)) != null && (r6 = d16.a()) != null && intOrNull != null) {
            int intValue = intOrNull.intValue();
            d();
            Set<Integer> set = mmkvServiceIdList;
            if (set.contains(Integer.valueOf(intValue))) {
                return;
            }
            if (c(intValue)) {
                set.add(Integer.valueOf(intValue));
                return;
            }
            boolean checkEmoticonShouldHide = QQSysAndEmojiResMgr.getInstance().getResImpl(1).checkEmoticonShouldHide(QQSysFaceUtil.convertToLocal(intValue));
            if (checkEmoticonShouldHide) {
                QQSysAndEmojiResMgr.getInstance().refreshConfig(PullMomentType.TRIGGER_SPECIFIC_EMOJI_RANDOM_RESULT, true, true);
            }
            e(intValue);
            set.add(Integer.valueOf(intValue));
            QLog.i("RareConfigFetchHelper", 1, "checkRefreshConfigIfNeed rareServiceId:" + intValue + ", isHide:" + checkEmoticonShouldHide + " triggerId: " + triggerServiceId + " resultId: " + resultId);
        }
    }
}
