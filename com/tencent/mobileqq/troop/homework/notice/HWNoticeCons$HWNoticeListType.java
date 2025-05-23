package com.tencent.mobileqq.troop.homework.notice;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeListType", "", "Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeListType;", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "NOTICE_LIST_TYPE_MY_PUBLISH", "NOTICE_LIST_TYPE_ALL", "NOTICE_LIST_TYPE_NO_CONFIRM", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWNoticeCons$HWNoticeListType {
    private static final /* synthetic */ HWNoticeCons$HWNoticeListType[] $VALUES;
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final HWNoticeCons$HWNoticeListType NOTICE_LIST_TYPE_ALL;
    public static final HWNoticeCons$HWNoticeListType NOTICE_LIST_TYPE_MY_PUBLISH;
    public static final HWNoticeCons$HWNoticeListType NOTICE_LIST_TYPE_NO_CONFIRM;
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeListType$a;", "", "", "value", "Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeListType;", "a", "(Ljava/lang/Integer;)Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeListType;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.notice.HWNoticeCons$HWNoticeListType$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final HWNoticeCons$HWNoticeListType a(@Nullable Integer value) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (HWNoticeCons$HWNoticeListType) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value);
            }
            for (HWNoticeCons$HWNoticeListType hWNoticeCons$HWNoticeListType : HWNoticeCons$HWNoticeListType.values()) {
                int value2 = hWNoticeCons$HWNoticeListType.getValue();
                if (value != null && value2 == value.intValue()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return hWNoticeCons$HWNoticeListType;
                }
            }
            return null;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static final /* synthetic */ HWNoticeCons$HWNoticeListType[] $values() {
        return new HWNoticeCons$HWNoticeListType[]{NOTICE_LIST_TYPE_MY_PUBLISH, NOTICE_LIST_TYPE_ALL, NOTICE_LIST_TYPE_NO_CONFIRM};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52255);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        NOTICE_LIST_TYPE_MY_PUBLISH = new HWNoticeCons$HWNoticeListType("NOTICE_LIST_TYPE_MY_PUBLISH", 0, 3);
        NOTICE_LIST_TYPE_ALL = new HWNoticeCons$HWNoticeListType("NOTICE_LIST_TYPE_ALL", 1, 1);
        NOTICE_LIST_TYPE_NO_CONFIRM = new HWNoticeCons$HWNoticeListType("NOTICE_LIST_TYPE_NO_CONFIRM", 2, 2);
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    HWNoticeCons$HWNoticeListType(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    public static HWNoticeCons$HWNoticeListType valueOf(String str) {
        return (HWNoticeCons$HWNoticeListType) Enum.valueOf(HWNoticeCons$HWNoticeListType.class, str);
    }

    public static HWNoticeCons$HWNoticeListType[] values() {
        return (HWNoticeCons$HWNoticeListType[]) $VALUES.clone();
    }

    public final int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.value;
    }
}
