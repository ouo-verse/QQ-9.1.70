package com.tencent.mobileqq.springhb.config;

import com.tencent.luggage.wxa.he.k;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.config.i;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0006\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/springhb/config/SpringHbUrlCheckConfProcessor;", "Lcom/tencent/mobileqq/springhb/config/SpringFestivalBaseConfProcessor;", "Lcom/tencent/mobileqq/springhb/config/i;", "", "Lcom/tencent/mobileqq/config/ai;", "confFiles", "d", "([Lcom/tencent/mobileqq/config/ai;)Lcom/tencent/mobileqq/springhb/config/i;", "Ljava/lang/Class;", "clazz", "", "type", "c", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SpringHbUrlCheckConfProcessor extends SpringFestivalBaseConfProcessor<i> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/springhb/config/SpringHbUrlCheckConfProcessor$a;", "", "Lcom/tencent/mobileqq/springhb/config/i;", "a", "", "CONFIG_ID", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.config.SpringHbUrlCheckConfProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

        @JvmStatic
        @Nullable
        public final i a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (i) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (i) am.s().x(k.CTRL_INDEX);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60559);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SpringHbUrlCheckConfProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final i b() {
        return INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i migrateOldOrDefaultContent(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (i) iPatchRedirector.redirect((short) 4, (Object) this, type);
        }
        return new i();
    }

    @Override // com.tencent.mobileqq.springhb.config.SpringFestivalBaseConfProcessor, com.tencent.mobileqq.config.l
    @NotNull
    public Class<i> clazz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return i.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.springhb.config.SpringFestivalBaseConfProcessor
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public i a(@NotNull ai[] confFiles) throws Exception {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, (Object) this, (Object) confFiles);
        }
        Intrinsics.checkNotNullParameter(confFiles, "confFiles");
        boolean z17 = true;
        if (confFiles.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            String content = confFiles[0].f202268b;
            if (QLog.isColorLevel()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("onParsed %s", Arrays.copyOf(new Object[]{content}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.i("SpringHb_SpringHbUrlCheckConfProcessor", 2, format);
            }
            if (content != null && content.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                i.Companion companion = i.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(content, "content");
                return companion.a(content);
            }
        }
        return new i();
    }

    @Override // com.tencent.mobileqq.springhb.config.SpringFestivalBaseConfProcessor, com.tencent.mobileqq.config.l
    public int type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return k.CTRL_INDEX;
    }
}
