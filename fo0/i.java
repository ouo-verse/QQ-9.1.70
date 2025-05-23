package fo0;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aio.data.AIOContact;
import com.tencent.guild.api.emoji.ISouGouEmoProxyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J&\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0014"}, d2 = {"Lfo0/i;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "data", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "a", "Lcom/tencent/aio/data/AIOContact;", "contact", "d", "c", "", "action", "e", "b", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f400161a = new i();

    i() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        if (r1 == null) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a(Context context, Bundle data, com.tencent.aio.api.runtime.a aioContext) {
        Cursor cursor;
        ?? r16 = InputMethodUtil.EXP_PATH_URI;
        Uri uri = (Uri) data.getParcelable(InputMethodUtil.EXP_PATH_URI);
        if (uri == null) {
            return;
        }
        Cursor cursor2 = null;
        r9 = null;
        String str = null;
        try {
            try {
                cursor = ContactsMonitor.query(context.getContentResolver(), uri, null, null, null, null, null);
            } catch (Exception e16) {
                e = e16;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (cursor2 != null) {
                }
                throw th;
            }
            try {
                Intrinsics.checkNotNull(cursor);
                cursor.moveToFirst();
                str = cursor.getString(cursor.getColumnIndexOrThrow(InputMethodUtil.SOUGOU_URI_DISPLAYNAME));
                r16 = cursor;
            } catch (Exception e17) {
                e = e17;
                QLog.e("IMECommandUtil", 1, e, new Object[0]);
                r16 = cursor;
            }
            r16.close();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            QLog.i("IMECommandUtil", 1, "newSendExp uriPath: " + uri + ", finalTargetName: " + str);
            ((ISouGouEmoProxyApi) QRoute.api(ISouGouEmoProxyApi.class)).sendNewExp(context, aioContext, uri, str);
        } catch (Throwable th6) {
            th = th6;
            cursor2 = r16;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    private final void c(Context context, Bundle data, AIOContact contact) {
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null) {
            return;
        }
        ((ISouGouEmoProxyApi) QRoute.api(ISouGouEmoProxyApi.class)).pullMultipleEmojiKey(activity, contact.f(), contact.j(), data.getStringArrayList(InputMethodUtil.BUNDLE_KEY_SOGOU_EXP_ALL_PACKID));
    }

    private final void d(Context context, Bundle data, AIOContact contact) {
        Activity activity;
        int i3 = data.getInt(InputMethodUtil.BUNDLE_KEY_SOGOU_PACK_ID);
        String string = data.getString(InputMethodUtil.BUNDLE_KEY_SOGOU_EXP_ID);
        QLog.d("IMECommandUtil", 2, "sendEmojiId, packId:" + i3 + ",exprId:" + string + ",ePath:" + data.getString(InputMethodUtil.BUDNLE_KEY_SOGOU_EXP_PATH));
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        Activity activity2 = activity;
        if (activity2 == null) {
            return;
        }
        ((ISouGouEmoProxyApi) QRoute.api(ISouGouEmoProxyApi.class)).trySend(activity2, contact.f(), contact.j(), i3, string);
    }

    private final void e(Context context, String action, Bundle data, AIOContact contact) {
        String string;
        Activity activity;
        if (Intrinsics.areEqual(InputMethodUtil.ACTION_SOGOU_EXPRESSION, action)) {
            string = data.getString(InputMethodUtil.KEY_SOGOU_EXPRESSION);
        } else {
            string = data.getString(InputMethodUtil.KEY_QQPINYIN_EXPRESSION);
        }
        String str = string;
        QLog.d("IMECommandUtil", 2, "sendExp, path:" + str);
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        Activity activity2 = activity;
        if (activity2 == null) {
            return;
        }
        ((ISouGouEmoProxyApi) QRoute.api(ISouGouEmoProxyApi.class)).sendIMEEXpression(activity2, contact.f(), contact.j(), str, action);
    }

    public final void b(@NotNull Context context, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String action, @NotNull Bundle data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            AIOContact c16 = aioContext.g().r().c();
            QLog.i("IMECommandUtil", 1, "onPrivateIMECommand, action:" + action + " data:" + data);
            if (Intrinsics.areEqual(InputMethodUtil.ACTION_SOUGOU_NEW_EXP, action)) {
                a(context, data, aioContext);
            } else {
                if (!Intrinsics.areEqual(InputMethodUtil.ACTION_SOGOU_EXPRESSION, action) && !Intrinsics.areEqual(InputMethodUtil.ACTION_QQPINYIN_EXPRESSION, action)) {
                    if (Intrinsics.areEqual(InputMethodUtil.ACTION_SOGOU_APP_ID, action)) {
                        c(context, data, c16);
                    } else if (Intrinsics.areEqual(InputMethodUtil.ACTION_SOGOU_QQEXP, action) || Intrinsics.areEqual(InputMethodUtil.ACTION_QQPINYIN_QQEXP, action)) {
                        d(context, data, c16);
                    }
                }
                e(context, action, data, c16);
            }
        } catch (Exception e16) {
            QLog.e("IMECommandUtil", 1, String.valueOf(e16));
        }
    }
}
