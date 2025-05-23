package com.tencent.mobileqq.aio.reserve1.toptip;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.aio.notification.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqui.widget.TipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c extends com.tencent.qqnt.aio.toptips.a implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.qqnt.aio.toptips.c f193407d;

    /* renamed from: e, reason: collision with root package name */
    private final View.OnClickListener f193408e;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                com.tencent.qqnt.aio.d.INSTANCE.c(false);
                c.this.f193407d.h(c.this);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f193408e = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit o(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
        if (num.intValue() == 100 || num.intValue() == 2) {
            com.tencent.qqnt.aio.d.INSTANCE.c(false);
            this.f193407d.h(this);
            return null;
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public View a(Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) objArr);
        }
        Context context = this.f193407d.a().c().getContext();
        TipsBar tipsBar = new TipsBar(context);
        tipsBar.setBarType(4);
        tipsBar.setTipsText(context.getString(R.string.yrz));
        tipsBar.setTipsIcon(context.getResources().getDrawable(R.drawable.common_banner_tips_warning));
        tipsBar.D(true);
        tipsBar.setOnClickListener(this.f193408e);
        return tipsBar;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new int[0];
    }

    @Override // com.tencent.mobileqq.aio.notification.e
    @NonNull
    public IAIONotificationUIModel e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (IAIONotificationUIModel) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new IAIONotificationUIModel.b(AIONotificationBusiId.AIO_MONITOR, this.f193407d.a().c().getContext().getString(R.string.yrz), IAIONotificationUIModel.ActionIcon.CLOSE, "", 0, new Function2() { // from class: com.tencent.mobileqq.aio.reserve1.toptip.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit o16;
                o16 = c.this.o((IAIONotificationUIModel) obj, (Integer) obj2);
                return o16;
            }
        });
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public void g(@NonNull com.tencent.qqnt.aio.toptips.c cVar, int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, cVar, Integer.valueOf(i3), objArr);
        } else if (i3 == 1005) {
            this.f193407d = cVar;
            if (com.tencent.qqnt.aio.d.INSTANCE.a()) {
                cVar.e(this);
            }
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 34;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public List<AIONotificationBusiId> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(AIONotificationBusiId.AIO_MONITOR);
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public void m(@NonNull com.tencent.mobileqq.aio.notification.c cVar, int i3, @Nullable Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, cVar, Integer.valueOf(i3), objArr);
        } else {
            g((com.tencent.qqnt.aio.toptips.c) cVar, i3, objArr);
        }
    }
}
