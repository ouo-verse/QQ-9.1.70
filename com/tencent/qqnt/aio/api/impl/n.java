package com.tencent.qqnt.aio.api.impl;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.menu.MenuUtils;
import com.tencent.qqnt.aio.utils.ViewUtils;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\"\u0014\u0010\b\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0014\u0010\n\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\"\u0014\u0010\f\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007\"\u0014\u0010\u000e\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007\"\u0014\u0010\u0010\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007\"\u0014\u0010\u0012\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007\"\u0014\u0010\u0014\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0007\"\u0014\u0010\u0016\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0007\"\u0014\u0010\u0018\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0007\"\u0014\u0010\u001a\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0007\u00a8\u0006\u001b"}, d2 = {"", "l", "", "msg", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "I", "perLineCount", "b", "iconWidthWide", "c", "iconHeightWide", "d", "iconWidthNarrow", "e", "iconHeightNarrow", "f", "clickTag", "g", "separateIconWith", tl.h.F, "separateIconHeight", "i", "separateIconParentHeight", "j", "separateIconParentWidth", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final int f348954a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f348955b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f348956c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f348957d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f348958e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f348959f;

    /* renamed from: g, reason: collision with root package name */
    private static final int f348960g;

    /* renamed from: h, reason: collision with root package name */
    private static final int f348961h;

    /* renamed from: i, reason: collision with root package name */
    private static final int f348962i;

    /* renamed from: j, reason: collision with root package name */
    private static final int f348963j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65438);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f348954a = l();
        ViewUtils viewUtils = ViewUtils.f352270a;
        f348955b = viewUtils.a(46.0f);
        f348956c = viewUtils.a(39.0f);
        f348957d = viewUtils.a(44.0f);
        f348958e = viewUtils.a(37.0f);
        f348959f = R.id.z3r;
        int b16 = com.tencent.qqnt.aio.utils.l.b(32);
        f348960g = b16;
        f348961h = b16;
        f348962i = com.tencent.qqnt.aio.utils.l.b(48);
        f348963j = com.tencent.qqnt.aio.utils.l.b(44);
    }

    private static final int l() {
        if (MenuUtils.f351230a.l()) {
            if (com.tencent.qqnt.aio.menu.ui.e.f351563b != 5) {
                return 5;
            }
            return 7;
        }
        if (com.tencent.qqnt.aio.menu.ui.e.f351563b != 5) {
            return 5;
        }
        return 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d(AIOEmoReplyMenuApiImpl.TAG, 2, obj.toString());
        }
    }
}
