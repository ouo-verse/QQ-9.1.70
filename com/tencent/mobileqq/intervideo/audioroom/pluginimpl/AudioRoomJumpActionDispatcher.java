package com.tencent.mobileqq.intervideo.audioroom.pluginimpl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/intervideo/audioroom/pluginimpl/AudioRoomJumpActionDispatcher;", "", "", ZPlanPublishSource.FROM_SCHEME, "", "dispatch", "", "b", "c", "d", "e", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class AudioRoomJumpActionDispatcher {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final AudioRoomJumpActionDispatcher INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58547);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new AudioRoomJumpActionDispatcher();
        }
    }

    AudioRoomJumpActionDispatcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<String, String> a(String scheme) {
        int indexOf$default;
        List split$default;
        List split$default2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) scheme, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
        if (indexOf$default >= 0) {
            String substring = scheme.substring(indexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            split$default = StringsKt__StringsKt.split$default((CharSequence) substring, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                if (split$default2.size() == 2) {
                    linkedHashMap.put(split$default2.get(0), split$default2.get(1));
                }
            }
        }
        return linkedHashMap;
    }

    private final boolean b(String scheme) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(scheme, "https", false, 2, null);
        return startsWith$default;
    }

    private final void c(String scheme) {
        String str = a(scheme).get("uin");
        if (str == null) {
            QLog.w("AudioRoomJumpActionDispatcher", 2, "openStrangerAIO fail: " + scheme);
            return;
        }
        Context baseContext = BaseApplicationImpl.getApplication().getBaseContext();
        Intent intent = new Intent(baseContext, (Class<?>) ChatActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("uin", str);
        intent.putExtra("uintype", 10010);
        baseContext.startActivity(intent);
    }

    private final void d(String scheme) {
        Intent intent = new Intent(BaseApplicationImpl.getApplication().getBaseContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", scheme);
        intent.addFlags(268435456);
        BaseApplicationImpl.getApplication().getBaseContext().startActivity(intent);
    }

    @JvmStatic
    public static final void dispatch(@NotNull String scheme) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(scheme, "openStrangerAIO", false, 2, null);
        if (startsWith$default) {
            INSTANCE.c(scheme);
            return;
        }
        AudioRoomJumpActionDispatcher audioRoomJumpActionDispatcher = INSTANCE;
        if (audioRoomJumpActionDispatcher.b(scheme)) {
            audioRoomJumpActionDispatcher.d(scheme);
        } else {
            audioRoomJumpActionDispatcher.e(scheme);
        }
    }

    private final void e(String scheme) {
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(scheme));
        intent.setFlags(268435456);
        BaseApplicationImpl.getApplication().getBaseContext().startActivity(intent);
    }
}
