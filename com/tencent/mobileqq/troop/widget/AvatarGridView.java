package com.tencent.mobileqq.troop.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.GridView;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AvatarGridView extends GridView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected WindowManager f302270d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f302271e;

    /* renamed from: f, reason: collision with root package name */
    protected int f302272f;

    public AvatarGridView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int getChildDrawingOrder(int i3, int i16) {
        com.tencent.mobileqq.troop.avatar.a aVar;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (getAdapter() != null) {
            int i19 = i3 - 1;
            if (getAdapter().getItem(i19) instanceof com.tencent.mobileqq.troop.avatar.a) {
                aVar = (com.tencent.mobileqq.troop.avatar.a) getAdapter().getItem(i19);
                if (aVar == null && (i18 = aVar.f294531c) != 0 && i18 == 4) {
                    i17 = i3 - 1;
                } else {
                    i17 = i3;
                }
                if (i17 > 4) {
                    int i26 = i3 - 1;
                    if (i16 == i26) {
                        return 3;
                    }
                    int i27 = i3 - 2;
                    if (i16 == i27) {
                        return 4;
                    }
                    if (i16 == 4) {
                        return i27;
                    }
                    if (i16 == 3) {
                        return i26;
                    }
                }
                return super.getChildDrawingOrder(i3, i16);
            }
        }
        aVar = null;
        if (aVar == null) {
        }
        i17 = i3;
        if (i17 > 4) {
        }
        return super.getChildDrawingOrder(i3, i16);
    }

    @Override // com.tencent.widget.GridView
    public int getNumColumns() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f302272f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.GridView, com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE));
        }
    }

    @Override // com.tencent.widget.GridView
    public void setNumColumns(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f302272f = i3;
            super.setNumColumns(i3);
        }
    }

    public AvatarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public AvatarGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f302270d = null;
        this.f302271e = false;
        this.f302272f = 4;
        setChildrenDrawingOrderEnabled(true);
    }
}
