package com.tencent.mobileqq.notification.modularize;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.BaseConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001B\u00d7\u0001\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\b\b\u0002\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b=\u0010>B\t\b\u0016\u00a2\u0006\u0004\b=\u0010?J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u00d9\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\b\b\u0002\u0010\"\u001a\u00020!H\u00c6\u0001J\t\u0010$\u001a\u00020\u0011H\u00d6\u0001J\t\u0010%\u001a\u00020\bH\u00d6\u0001J\u0013\u0010'\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010(R\u0016\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010*R\u0016\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010(R\u0016\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010(R\u0016\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010(R\u0016\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010(R\u0016\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u0013\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010\u0014\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u0010\u0015\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010,R\u0016\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0016\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010,R\u0016\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010,R\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b5\u00104R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010\u001d\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010(R\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/notification/modularize/f;", "", "", "g", "c", "d", "f", "e", "", "mainBusinessId", "subBusinessId", "", "time", BaseConstants.EXTRA_PUSHID, "notifyId", QQBrowserActivity.KEY_MSG_TYPE, "type", "", "title", "iconUrl", "contentText", "jumpScheme", "triggerInfo", "senderIcon", "from", "isUrlJump", "isRevokePush", "Lcom/tencent/mobileqq/notification/modularize/b;", "forcePushInfo", "style", "", "Lcom/tencent/mobileqq/notification/modularize/a;", "buttons", "", "bytesExtData", "a", "toString", "hashCode", "other", "equals", "I", "b", "J", tl.h.F, "Ljava/lang/String;", "i", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "Z", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/notification/modularize/b;", "r", ReportConstant.COSTREPORT_PREFIX, "Ljava/util/List;", "t", "[B", "<init>", "(IIJIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/tencent/mobileqq/notification/modularize/b;ILjava/util/List;[B)V", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final /* data */ class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int mainBusinessId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int subBusinessId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long time;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int pushId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int notifyId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int msgType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int type;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String title;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String iconUrl;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String contentText;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String jumpScheme;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String triggerInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String senderIcon;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String from;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public boolean isUrlJump;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public boolean isRevokePush;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public b forcePushInfo;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int style;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public List<a> buttons;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public byte[] bytesExtData;

    public f(int i3, int i16, long j3, int i17, int i18, int i19, int i26, @NotNull String title, @NotNull String iconUrl, @NotNull String contentText, @NotNull String jumpScheme, @NotNull String triggerInfo, @NotNull String senderIcon, @NotNull String from, boolean z16, boolean z17, @Nullable b bVar, int i27, @NotNull List<a> buttons, @NotNull byte[] bytesExtData) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        Intrinsics.checkNotNullParameter(jumpScheme, "jumpScheme");
        Intrinsics.checkNotNullParameter(triggerInfo, "triggerInfo");
        Intrinsics.checkNotNullParameter(senderIcon, "senderIcon");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(bytesExtData, "bytesExtData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), title, iconUrl, contentText, jumpScheme, triggerInfo, senderIcon, from, Boolean.valueOf(z16), Boolean.valueOf(z17), bVar, Integer.valueOf(i27), buttons, bytesExtData);
            return;
        }
        this.mainBusinessId = i3;
        this.subBusinessId = i16;
        this.time = j3;
        this.pushId = i17;
        this.notifyId = i18;
        this.msgType = i19;
        this.type = i26;
        this.title = title;
        this.iconUrl = iconUrl;
        this.contentText = contentText;
        this.jumpScheme = jumpScheme;
        this.triggerInfo = triggerInfo;
        this.senderIcon = senderIcon;
        this.from = from;
        this.isUrlJump = z16;
        this.isRevokePush = z17;
        this.forcePushInfo = bVar;
        this.style = i27;
        this.buttons = buttons;
        this.bytesExtData = bytesExtData;
    }

    @NotNull
    public final f a(int mainBusinessId, int subBusinessId, long time, int pushId, int notifyId, int msgType, int type, @NotNull String title, @NotNull String iconUrl, @NotNull String contentText, @NotNull String jumpScheme, @NotNull String triggerInfo, @NotNull String senderIcon, @NotNull String from, boolean isUrlJump, boolean isRevokePush, @Nullable b forcePushInfo, int style, @NotNull List<a> buttons, @NotNull byte[] bytesExtData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (f) iPatchRedirector.redirect((short) 29, this, Integer.valueOf(mainBusinessId), Integer.valueOf(subBusinessId), Long.valueOf(time), Integer.valueOf(pushId), Integer.valueOf(notifyId), Integer.valueOf(msgType), Integer.valueOf(type), title, iconUrl, contentText, jumpScheme, triggerInfo, senderIcon, from, Boolean.valueOf(isUrlJump), Boolean.valueOf(isRevokePush), forcePushInfo, Integer.valueOf(style), buttons, bytesExtData);
        }
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        Intrinsics.checkNotNullParameter(jumpScheme, "jumpScheme");
        Intrinsics.checkNotNullParameter(triggerInfo, "triggerInfo");
        Intrinsics.checkNotNullParameter(senderIcon, "senderIcon");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(bytesExtData, "bytesExtData");
        return new f(mainBusinessId, subBusinessId, time, pushId, notifyId, msgType, type, title, iconUrl, contentText, jumpScheme, triggerInfo, senderIcon, from, isUrlJump, isRevokePush, forcePushInfo, style, buttons, bytesExtData);
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.msgType != 1) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        b bVar = this.forcePushInfo;
        if (bVar != null) {
            String str2 = null;
            if (bVar != null) {
                str = bVar.actionText;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                b bVar2 = this.forcePushInfo;
                if (bVar2 != null) {
                    str2 = bVar2.actionJump;
                }
                if (!TextUtils.isEmpty(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean e() {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            contains = ArraysKt___ArraysKt.contains(new Integer[]{0, 2}, Integer.valueOf(this.type));
            return contains;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        if (this.mainBusinessId == fVar.mainBusinessId && this.subBusinessId == fVar.subBusinessId && this.time == fVar.time && this.pushId == fVar.pushId && this.notifyId == fVar.notifyId && this.msgType == fVar.msgType && this.type == fVar.type && Intrinsics.areEqual(this.title, fVar.title) && Intrinsics.areEqual(this.iconUrl, fVar.iconUrl) && Intrinsics.areEqual(this.contentText, fVar.contentText) && Intrinsics.areEqual(this.jumpScheme, fVar.jumpScheme) && Intrinsics.areEqual(this.triggerInfo, fVar.triggerInfo) && Intrinsics.areEqual(this.senderIcon, fVar.senderIcon) && Intrinsics.areEqual(this.from, fVar.from) && this.isUrlJump == fVar.isUrlJump && this.isRevokePush == fVar.isRevokePush && Intrinsics.areEqual(this.forcePushInfo, fVar.forcePushInfo) && this.style == fVar.style && Intrinsics.areEqual(this.buttons, fVar.buttons) && Intrinsics.areEqual(this.bytesExtData, fVar.bytesExtData)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            contains = ArraysKt___ArraysKt.contains(new Integer[]{1, 2, 3}, Integer.valueOf(this.type));
            return contains;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        int i3 = this.notifyId;
        if (528 > i3 || i3 >= 3000529) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        int a16 = ((((((((((((((((((((((((((this.mainBusinessId * 31) + this.subBusinessId) * 31) + androidx.fragment.app.a.a(this.time)) * 31) + this.pushId) * 31) + this.notifyId) * 31) + this.msgType) * 31) + this.type) * 31) + this.title.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.contentText.hashCode()) * 31) + this.jumpScheme.hashCode()) * 31) + this.triggerInfo.hashCode()) * 31) + this.senderIcon.hashCode()) * 31) + this.from.hashCode()) * 31;
        boolean z16 = this.isUrlJump;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (a16 + i16) * 31;
        boolean z17 = this.isRevokePush;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i18 = (i17 + i3) * 31;
        b bVar = this.forcePushInfo;
        if (bVar == null) {
            hashCode = 0;
        } else {
            hashCode = bVar.hashCode();
        }
        return ((((((i18 + hashCode) * 31) + this.style) * 31) + this.buttons.hashCode()) * 31) + Arrays.hashCode(this.bytesExtData);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return "PushComponent(mainBusinessId=" + this.mainBusinessId + ", subBusinessId=" + this.subBusinessId + ", time=" + this.time + ", pushId=" + this.pushId + ", notifyId=" + this.notifyId + ", msgType=" + this.msgType + ", type=" + this.type + ", title=" + this.title + ", iconUrl=" + this.iconUrl + ", contentText=" + this.contentText + ", jumpScheme=" + this.jumpScheme + ", triggerInfo=" + this.triggerInfo + ", senderIcon=" + this.senderIcon + ", from=" + this.from + ", isUrlJump=" + this.isUrlJump + ", isRevokePush=" + this.isRevokePush + ", forcePushInfo=" + this.forcePushInfo + ", style=" + this.style + ", buttons=" + this.buttons + ", bytesExtData=" + Arrays.toString(this.bytesExtData) + ")";
    }

    public /* synthetic */ f(int i3, int i16, long j3, int i17, int i18, int i19, int i26, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z16, boolean z17, b bVar, int i27, List list, byte[] bArr, int i28, DefaultConstructorMarker defaultConstructorMarker) {
        this((i28 & 1) != 0 ? 0 : i3, (i28 & 2) != 0 ? 0 : i16, (i28 & 4) != 0 ? 0L : j3, (i28 & 8) != 0 ? 0 : i17, (i28 & 16) != 0 ? 0 : i18, (i28 & 32) != 0 ? 0 : i19, (i28 & 64) != 0 ? 0 : i26, (i28 & 128) != 0 ? "" : str, (i28 & 256) != 0 ? "" : str2, (i28 & 512) != 0 ? "" : str3, (i28 & 1024) != 0 ? "" : str4, (i28 & 2048) != 0 ? "" : str5, (i28 & 4096) != 0 ? "" : str6, (i28 & 8192) != 0 ? "" : str7, (i28 & 16384) != 0 ? true : z16, (32768 & i28) != 0 ? false : z17, (65536 & i28) != 0 ? null : bVar, (131072 & i28) != 0 ? 0 : i27, (262144 & i28) != 0 ? new ArrayList() : list, (524288 & i28) != 0 ? new byte[0] : bArr);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), str, str2, str3, str4, str5, str6, str7, Boolean.valueOf(z16), Boolean.valueOf(z17), bVar, Integer.valueOf(i27), list, bArr, Integer.valueOf(i28), defaultConstructorMarker);
    }

    public f() {
        this(0, 0, 0L, 0, 0, 0, 0, null, null, null, null, null, null, null, false, false, null, 0, null, null, 1048574, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
