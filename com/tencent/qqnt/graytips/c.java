package com.tencent.qqnt.graytips;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.graytips.action.f;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B-\b\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0016\u0010\u0017B;\b\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0016\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\u0004\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/graytips/c;", "", "", "b", "a", "I", "start", "end", "<set-?>", "c", "()I", "color", "Lcom/tencent/qqnt/graytips/action/f;", "d", "Lcom/tencent/qqnt/graytips/action/f;", "actionInfo", "", "e", "Ljava/lang/String;", "iconUrl", "f", QCircleSchemeAttr.Polymerize.ALT, "<init>", "(IIILcom/tencent/qqnt/graytips/action/f;)V", "(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/qqnt/graytips/action/f;)V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int start;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int end;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int color;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public final f actionInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public String iconUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public String alt;

    @JvmOverloads
    public c(int i3, int i16, int i17, @Nullable f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), fVar);
            return;
        }
        this.start = i3;
        this.end = i16;
        this.color = i17;
        this.actionInfo = fVar;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.color;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        int i3 = this.color;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    return a.f356790a;
                }
                return a.f356793d;
            }
            return a.f356791b;
        }
        return a.f356792c;
    }

    public /* synthetic */ c(int i3, int i16, int i17, f fVar, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, i17, (i18 & 8) != 0 ? null : fVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), fVar, Integer.valueOf(i18), defaultConstructorMarker);
    }

    @JvmOverloads
    public c(int i3, int i16, @Nullable String str, @Nullable String str2, @Nullable f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, fVar);
            return;
        }
        this.color = 1;
        this.start = i3;
        this.end = i16;
        this.iconUrl = str;
        this.alt = str2;
        this.actionInfo = fVar;
    }
}
