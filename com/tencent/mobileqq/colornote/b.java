package com.tencent.mobileqq.colornote;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.mini.servlet.CreateUpdatableMsgServlet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import mqq.util.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<ColorNoteCurd> f201386a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ColorNoteCurd colorNoteCurd) {
        this.f201386a = new WeakReference<>(colorNoteCurd);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Object obj;
        Object obj2;
        ColorNoteCurd colorNoteCurd = this.f201386a.get();
        if (colorNoteCurd == null) {
            return;
        }
        g h16 = colorNoteCurd.h();
        int i3 = message.what;
        boolean z16 = true;
        switch (i3) {
            case 3:
            case 4:
                if (h16 != null) {
                    Bundle bundle = (Bundle) message.obj;
                    if (i3 != 3) {
                        z16 = false;
                    }
                    h16.onAddColorNote(bundle, z16);
                    return;
                }
                return;
            case 5:
            case 6:
                if (h16 != null) {
                    try {
                        Pair pair = (Pair) message.obj;
                        int intValue = ((Integer) pair.first).intValue();
                        String str = (String) pair.second;
                        if (message.what == 5) {
                            z16 = false;
                        }
                        h16.onDeleteColorNote(intValue, str, z16);
                        return;
                    } catch (ClassCastException e16) {
                        QLog.e("ColorNoteHandler", 2, e16, new Object[0]);
                        return;
                    } catch (Exception e17) {
                        QLog.e("ColorNoteHandler", 2, e17, new Object[0]);
                        return;
                    }
                }
                return;
            case 7:
            case 8:
            default:
                return;
            case 9:
                if (h16 != null && (obj = message.obj) != null) {
                    Bundle bundle2 = (Bundle) obj;
                    h16.onUpdateColorNoteState(bundle2.getInt(CreateUpdatableMsgServlet.KEY_SERVICE_TYPE), bundle2.getString("key_sub_type"), bundle2);
                    return;
                }
                return;
            case 10:
            case 11:
                if (h16 != null && (obj2 = message.obj) != null) {
                    ColorNote colorNote = (ColorNote) obj2;
                    if (i3 != 10) {
                        z16 = false;
                    }
                    h16.onUpdateColorNote(colorNote, z16);
                    return;
                }
                return;
        }
    }
}
