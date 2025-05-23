package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.ui.widget.MenuDialog;
import com.tencent.timi.game.ui.widget.e;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ac {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.tim.api.message.a f376612d;

        a(com.tencent.timi.game.tim.api.message.a aVar) {
            this.f376612d = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 != 0) {
                if (i3 == 1) {
                    pn4.f.b(this.f376612d);
                }
            } else {
                pn4.f.d(this.f376612d);
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.tim.api.message.a f376614d;

        b(com.tencent.timi.game.tim.api.message.a aVar) {
            this.f376614d = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            pn4.f.b(this.f376614d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LongClickOperOption[] f376616d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f376617e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.tim.api.message.a f376618f;

        c(LongClickOperOption[] longClickOperOptionArr, Context context, com.tencent.timi.game.tim.api.message.a aVar) {
            this.f376616d = longClickOperOptionArr;
            this.f376617e = context;
            this.f376618f = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            int i16 = e.f376622a[this.f376616d[i3].ordinal()];
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 == 4) {
                            ac.this.c(this.f376617e, this.f376618f);
                        } else if (i16 == 5) {
                            ac.this.d(this.f376617e, this.f376618f);
                        }
                    } else {
                        pn4.f.c(this.f376618f);
                    }
                } else {
                    pn4.f.b(this.f376618f);
                }
            } else {
                pn4.f.a(this.f376617e, this.f376618f);
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.tim.api.message.a f376620d;

        d(com.tencent.timi.game.tim.api.message.a aVar) {
            this.f376620d = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (yn4.d.d() - this.f376620d.time() < 120000) {
                pn4.f.e(this.f376620d);
            } else {
                pn4.f.INSTANCE.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f376622a;

        static {
            int[] iArr = new int[LongClickOperOption.values().length];
            f376622a = iArr;
            try {
                iArr[LongClickOperOption.COPY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f376622a[LongClickOperOption.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f376622a[LongClickOperOption.REPORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f376622a[LongClickOperOption.REVOCATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f376622a[LongClickOperOption.FAVORITE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, com.tencent.timi.game.tim.api.message.a aVar) {
        if (yn4.d.d() - aVar.time() < 120000) {
            new e.a(context).j("\u662f\u5426\u64a4\u56de\u8be5\u6761\u6d88\u606f?").o(new d(aVar)).c().show();
        } else {
            pn4.f.INSTANCE.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, com.tencent.timi.game.tim.api.message.a aVar) {
        QBaseActivity b16;
        if (context instanceof QBaseActivity) {
            b16 = (QBaseActivity) context;
        } else {
            b16 = vf4.a.b();
        }
        if (b16 == null) {
            com.tencent.timi.game.utils.l.e("MessageViewOperator", "doFavorite failed, context:" + context);
            com.tencent.timi.game.ui.widget.f.d(true, "\u6536\u85cf\u5931\u8d25");
            return;
        }
        wg4.a.f445636a.a(b16, aVar);
    }

    private String[] e(LongClickOperOption[] longClickOperOptionArr) {
        String[] strArr = new String[longClickOperOptionArr.length];
        for (int i3 = 0; i3 < longClickOperOptionArr.length; i3++) {
            int i16 = e.f376622a[longClickOperOptionArr[i3].ordinal()];
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 4) {
                            if (i16 == 5) {
                                strArr[i3] = "\u6536\u85cf";
                            }
                        } else {
                            strArr[i3] = "\u64a4\u56de";
                        }
                    } else {
                        strArr[i3] = "\u4e3e\u62a5";
                    }
                } else {
                    strArr[i3] = "\u5220\u9664";
                }
            } else {
                strArr[i3] = "\u590d\u5236";
            }
        }
        return strArr;
    }

    private void i(Context context, com.tencent.timi.game.tim.api.message.a aVar, String[] strArr, LongClickOperOption[] longClickOperOptionArr, int i3, int i16) {
        new MenuDialog.c(context).b(strArr, new c(longClickOperOptionArr, context, aVar)).a().S(i3, i16);
    }

    public void g(Context context, com.tencent.timi.game.tim.api.message.a aVar, LongClickOperOption[] longClickOperOptionArr, int i3, int i16) {
        LongClickOperOption[] longClickOperOptionArr2;
        if (aVar == null) {
            return;
        }
        if (aVar.h() == MsgStatus.FAILED) {
            h(context, aVar, i3, i16);
            return;
        }
        if (aVar.h() == MsgStatus.SENDING) {
            new MenuDialog.c(context).b(new String[]{"\u5220\u9664"}, new b(aVar)).a().S(i3, i16);
            return;
        }
        if (aVar.h() == MsgStatus.SUCCESS) {
            if (aVar.b() && System.currentTimeMillis() - aVar.time() < 120000) {
                int length = longClickOperOptionArr.length + 1;
                LongClickOperOption[] longClickOperOptionArr3 = new LongClickOperOption[length];
                System.arraycopy(longClickOperOptionArr, 0, longClickOperOptionArr3, 0, longClickOperOptionArr.length);
                longClickOperOptionArr3[length - 1] = LongClickOperOption.REVOCATION;
                longClickOperOptionArr2 = longClickOperOptionArr3;
            } else {
                longClickOperOptionArr2 = longClickOperOptionArr;
            }
            if (longClickOperOptionArr2 != null && longClickOperOptionArr2.length > 0) {
                i(context, aVar, e(longClickOperOptionArr2), longClickOperOptionArr2, i3, i16);
            }
        }
    }

    public void h(Context context, com.tencent.timi.game.tim.api.message.a aVar, int i3, int i16) {
        new MenuDialog.c(context).b(new String[]{"\u91cd\u53d1", "\u5220\u9664"}, new a(aVar)).a().S(i3, i16);
    }

    public void f() {
    }
}
