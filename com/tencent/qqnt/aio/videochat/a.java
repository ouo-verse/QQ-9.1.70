package com.tencent.qqnt.aio.videochat;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J,\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0007J6\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/videochat/a;", "", "", "d", "isVideoMsg", "isSendFromLocal", "isSender", "", "c", "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "app", "type", "", RemoteMessageConst.MessageBody.MSG_CONTENT, "", "a", "e", QQBrowserActivity.KEY_MSG_TYPE, "text", "b", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f352344a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47966);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f352344a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int c(boolean isVideoMsg, boolean isSendFromLocal, boolean isSender) {
        if (isVideoMsg) {
            if (!isSendFromLocal && !isSender) {
                return R.drawable.qui_video_on_filled_feedback_success;
            }
            return R.drawable.qui_video_on_filled_icon_white;
        }
        if (!isSendFromLocal && !isSender) {
            return R.drawable.qui_telephone_filled_feedback_success;
        }
        return R.drawable.qui_telephone_filled_bubble_host_text_primary;
    }

    private final boolean d() {
        return false;
    }

    @Nullable
    public final CharSequence a(@Nullable Context context, @Nullable AppRuntime app, int type, @NotNull String msgContent) {
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, this, context, app, Integer.valueOf(type), msgContent);
        }
        Intrinsics.checkNotNullParameter(msgContent, "msgContent");
        String str2 = null;
        if (e(type)) {
            if (context != null) {
                i3 = R.string.zlw;
                str = context.getString(i3);
            }
            str = null;
        } else {
            if (context != null) {
                i3 = R.string.zlv;
                str = context.getString(i3);
            }
            str = null;
        }
        if (!TextUtils.isEmpty(msgContent)) {
            return msgContent;
        }
        if (type != 3) {
            if (type != 4 && type != 5) {
                if (type != 6) {
                    switch (type) {
                        case 10:
                            break;
                        case 11:
                            break;
                        case 12:
                        case 13:
                            if (context != null) {
                                str2 = context.getString(R.string.id_);
                                break;
                            }
                            break;
                        default:
                            str2 = "";
                            break;
                    }
                }
                if (context != null) {
                    str2 = context.getString(R.string.id8);
                }
            }
            if (context != null) {
                str2 = context.getString(R.string.f173247id1);
            }
        } else if (context != null) {
            str2 = context.getString(R.string.id5);
        }
        return str + str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0073, code lost:
    
        if (r13 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0152, code lost:
    
        return com.tencent.mobileqq.R.drawable.qui_video_on_filled_icon_white;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
    
        return com.tencent.mobileqq.R.drawable.qui_video_on_filled_feedback_success;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
    
        if (r13 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return com.tencent.mobileqq.R.drawable.qui_telephone_filled_icon_white;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return com.tencent.mobileqq.R.drawable.qui_telephone_filled_feedback_success;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b1, code lost:
    
        if (r13 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b4, code lost:
    
        if (r13 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00eb, code lost:
    
        if (r13 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ee, code lost:
    
        if (r13 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0106, code lost:
    
        if (r13 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010a, code lost:
    
        if (r13 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0123, code lost:
    
        if (r13 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0127, code lost:
    
        if (r13 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0140, code lost:
    
        if (r13 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0144, code lost:
    
        if (r13 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014a, code lost:
    
        if (r13 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x014e, code lost:
    
        if (r13 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b(@NotNull Context context, int msgType, @NotNull String text, boolean isVideoMsg, boolean isSendFromLocal, boolean isSender) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        boolean contains$default5;
        boolean contains$default6;
        boolean contains$default7;
        boolean contains$default8;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, context, Integer.valueOf(msgType), text, Boolean.valueOf(isVideoMsg), Boolean.valueOf(isSendFromLocal), Boolean.valueOf(isSender))).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        if (d()) {
            String string = context.getString(R.string.f1781135s);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026av_group_voice_start_msg)");
            contains$default8 = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) string, false, 2, (Object) null);
            if (contains$default8) {
                return 0;
            }
            if (isVideoMsg) {
            }
        } else {
            String string2 = context.getString(R.string.idh);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.video_msg_time)");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) string2, false, 2, (Object) null);
            if (contains$default) {
                return c(isVideoMsg, isSendFromLocal, isSender);
            }
            String string3 = context.getString(R.string.f173247id1);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026video_msg_cancel_request)");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) string3, false, 2, (Object) null);
            if (contains$default2) {
                if (isVideoMsg) {
                }
            } else {
                String string4 = context.getString(R.string.id5);
                Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026msg_dont_respond_request)");
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) string4, false, 2, (Object) null);
                if (contains$default3) {
                    if (isVideoMsg) {
                        return R.drawable.qui_video_on_filled_feedback_error;
                    }
                    return R.drawable.qui_telephone_filled_feedback_error;
                }
                String string5 = context.getString(R.string.id8);
                Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri\u2026sg_friend_refuse_request)");
                contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) string5, false, 2, (Object) null);
                if (contains$default4) {
                    if (isVideoMsg) {
                    }
                } else {
                    String string6 = context.getString(R.string.id9);
                    Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri\u2026_handled_by_other_device)");
                    contains$default5 = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) string6, false, 2, (Object) null);
                    if (contains$default5) {
                        if (isVideoMsg) {
                        }
                    } else {
                        String string7 = context.getString(R.string.id7);
                        Intrinsics.checkNotNullExpressionValue(string7, "context.getString(R.stri\u2026end_recv_request_timeout)");
                        contains$default6 = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) string7, false, 2, (Object) null);
                        if (contains$default6) {
                            if (isVideoMsg) {
                            }
                        } else {
                            String string8 = context.getString(R.string.id_);
                            Intrinsics.checkNotNullExpressionValue(string8, "context.getString(R.stri\u2026as_switch_other_terminal)");
                            contains$default7 = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) string8, false, 2, (Object) null);
                            if (contains$default7) {
                                if (isVideoMsg) {
                                }
                            } else if (isVideoMsg) {
                            }
                        }
                    }
                }
            }
        }
    }

    public final boolean e(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, type)).booleanValue();
        }
        if (type != 2 && type != 3 && type != 4 && type != 5 && type != 6 && type != 12 && type != 26 && type != 28) {
            return false;
        }
        return true;
    }
}
