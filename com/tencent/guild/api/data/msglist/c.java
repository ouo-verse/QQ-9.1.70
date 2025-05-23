package com.tencent.guild.api.data.msglist;

import android.text.SpannableStringBuilder;
import android.text.method.MovementMethod;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bB\u0010CR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R.\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010 \u001a\u0004\u0018\u00010\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u000b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR.\u0010#\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001c\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR.\u0010)\u001a\u0004\u0018\u00010$2\b\u0010\u0013\u001a\u0004\u0018\u00010$8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010%\u001a\u0004\b\u0014\u0010&\"\u0004\b'\u0010(R.\u0010,\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b+\u0010\bR.\u00103\u001a\u0004\u0018\u00010-2\b\u0010\u0013\u001a\u0004\u0018\u00010-8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b*\u00100\"\u0004\b1\u00102R.\u0010:\u001a\u0004\u0018\u0001042\b\u0010\u0013\u001a\u0004\u0018\u0001048\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b5\u00107\"\u0004\b8\u00109RR\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010;j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`<2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010;j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`<8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010=\u001a\u0004\b.\u0010>\"\u0004\b?\u0010@\u00a8\u0006D"}, d2 = {"Lcom/tencent/guild/api/data/msglist/c;", "", "Ljava/lang/Object;", "a", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "setLock", "(Ljava/lang/Object;)V", JoinPoint.SYNCHRONIZATION_LOCK, "", "b", "Z", "e", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "preParsed", "Lcom/tencent/mobileqq/text/QQText;", "value", "c", "Lcom/tencent/mobileqq/text/QQText;", "d", "()Lcom/tencent/mobileqq/text/QQText;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/text/QQText;)V", "nickname", "", "Ljava/lang/String;", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "msgTime", "f", "o", "role", "", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "l", "(Ljava/lang/Integer;)V", "nickColor", "g", "j", "clientIdentity", "Landroid/text/SpannableStringBuilder;", h.F, "Landroid/text/SpannableStringBuilder;", "()Landroid/text/SpannableStringBuilder;", "p", "(Landroid/text/SpannableStringBuilder;)V", "textComponent", "Landroid/text/method/MovementMethod;", "i", "Landroid/text/method/MovementMethod;", "()Landroid/text/method/MovementMethod;", "r", "(Landroid/text/method/MovementMethod;)V", "textViewMovementMethod", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/util/ArrayList;)V", "textLayouts", "<init>", "()V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Object lock = new Object();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean preParsed;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQText nickname;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String msgTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String role;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer nickColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object clientIdentity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SpannableStringBuilder textComponent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MovementMethod textViewMovementMethod;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<Object> textLayouts;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Object getClientIdentity() {
        return this.clientIdentity;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getMsgTime() {
        return this.msgTime;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Integer getNickColor() {
        return this.nickColor;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final QQText getNickname() {
        return this.nickname;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getPreParsed() {
        return this.preParsed;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final SpannableStringBuilder getTextComponent() {
        return this.textComponent;
    }

    @Nullable
    public final ArrayList<Object> h() {
        return this.textLayouts;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final MovementMethod getTextViewMovementMethod() {
        return this.textViewMovementMethod;
    }

    public final void j(@Nullable Object obj) {
        synchronized (this.lock) {
            this.clientIdentity = obj;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void k(@Nullable String str) {
        synchronized (this.lock) {
            this.msgTime = str;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void l(@Nullable Integer num) {
        synchronized (this.lock) {
            this.nickColor = num;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void m(@Nullable QQText qQText) {
        synchronized (this.lock) {
            this.nickname = qQText;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void n(boolean z16) {
        this.preParsed = z16;
    }

    public final void o(@Nullable String str) {
        synchronized (this.lock) {
            this.role = str;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void p(@Nullable SpannableStringBuilder spannableStringBuilder) {
        synchronized (this.lock) {
            this.textComponent = spannableStringBuilder;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void q(@Nullable ArrayList<Object> arrayList) {
        synchronized (this.lock) {
            this.textLayouts = arrayList;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void r(@Nullable MovementMethod movementMethod) {
        synchronized (this.lock) {
            this.textViewMovementMethod = movementMethod;
            Unit unit = Unit.INSTANCE;
        }
    }
}
