package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FMDialogUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f209143d;

        a(c cVar) {
            this.f209143d = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f209143d.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f209144d;

        b(c cVar) {
            this.f209144d = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f209144d.a();
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        void a();

        void b();
    }

    public static void a(Context context, int i3, int i16, c cVar) {
        if (context == null) {
            context = QBaseActivity.sTopActivity;
        }
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FMDialogUtil<FileAssistant>", 2, "show dialog fail, context is null!");
                return;
            }
            return;
        }
        c(context, context.getString(i3), context.getString(i16), cVar);
    }

    public static void b(Context context, String str, int i3, c cVar) {
        if (context == null) {
            context = QBaseActivity.sTopActivity;
        }
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FMDialogUtil<FileAssistant>", 2, "show dialog fail, context is null!");
                return;
            }
            return;
        }
        c(context, str, context.getString(i3), cVar);
    }

    public static void c(final Context context, final String str, final CharSequence charSequence, c cVar) {
        final a aVar = new a(cVar);
        final b bVar = new b(cVar);
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.FMDialogUtil.3
                @Override // java.lang.Runnable
                public void run() {
                    Context context2 = context;
                    if ((context2 instanceof Activity) && ((Activity) context2).isFinishing()) {
                        return;
                    }
                    CharSequence charSequence2 = charSequence;
                    if (charSequence2 instanceof String) {
                        DialogUtil.createCustomDialog(context, 230, str, (String) charSequence2, R.string.b5j, R.string.b5o, aVar, bVar).show();
                    } else if (charSequence2 instanceof SpannableString) {
                        DialogUtil.createCustomDialogUrlWithoutAutoLink(context, 230, str, charSequence2, R.string.b5j, R.string.b5o, aVar, bVar).show();
                    }
                }
            });
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        if (charSequence instanceof String) {
            DialogUtil.createCustomDialog(context, 230, str, (String) charSequence, R.string.b5j, R.string.b5o, aVar, bVar).show();
        } else if (charSequence instanceof SpannableString) {
            DialogUtil.createCustomDialogUrlWithoutAutoLink(context, 230, str, charSequence, R.string.b5j, R.string.b5o, aVar, bVar).show();
        }
    }
}
