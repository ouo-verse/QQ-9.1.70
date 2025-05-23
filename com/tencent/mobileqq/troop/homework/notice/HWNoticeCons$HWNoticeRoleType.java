package com.tencent.mobileqq.troop.homework.notice;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeRoleType", "", "Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeRoleType;", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "ROLE_TYPE_TEACHER", "ROLE_TYPE_ADMIN_OR_OWNER", "ROLE_TYPE_PARENT", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWNoticeCons$HWNoticeRoleType {
    private static final /* synthetic */ HWNoticeCons$HWNoticeRoleType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final HWNoticeCons$HWNoticeRoleType ROLE_TYPE_ADMIN_OR_OWNER;
    public static final HWNoticeCons$HWNoticeRoleType ROLE_TYPE_PARENT;
    public static final HWNoticeCons$HWNoticeRoleType ROLE_TYPE_TEACHER;
    private final int value;

    private static final /* synthetic */ HWNoticeCons$HWNoticeRoleType[] $values() {
        return new HWNoticeCons$HWNoticeRoleType[]{ROLE_TYPE_TEACHER, ROLE_TYPE_ADMIN_OR_OWNER, ROLE_TYPE_PARENT};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52260);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ROLE_TYPE_TEACHER = new HWNoticeCons$HWNoticeRoleType("ROLE_TYPE_TEACHER", 0, 0);
        ROLE_TYPE_ADMIN_OR_OWNER = new HWNoticeCons$HWNoticeRoleType("ROLE_TYPE_ADMIN_OR_OWNER", 1, 1);
        ROLE_TYPE_PARENT = new HWNoticeCons$HWNoticeRoleType("ROLE_TYPE_PARENT", 2, 2);
        $VALUES = $values();
    }

    HWNoticeCons$HWNoticeRoleType(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    public static HWNoticeCons$HWNoticeRoleType valueOf(String str) {
        return (HWNoticeCons$HWNoticeRoleType) Enum.valueOf(HWNoticeCons$HWNoticeRoleType.class, str);
    }

    public static HWNoticeCons$HWNoticeRoleType[] values() {
        return (HWNoticeCons$HWNoticeRoleType[]) $VALUES.clone();
    }

    public final int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.value;
    }
}
