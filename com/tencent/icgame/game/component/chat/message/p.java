package com.tencent.icgame.game.component.chat.message;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.icgame.game.tim.api.message.MsgStatus;
import com.tencent.icgame.game.ui.widget.MenuDialog;
import com.tencent.icgame.game.ui.widget.e;
import com.tencent.mobileqq.app.QBaseActivity;

/* compiled from: P */
/* loaded from: classes7.dex */
public class p {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.icgame.game.tim.api.message.a f114984d;

        a(com.tencent.icgame.game.tim.api.message.a aVar) {
            this.f114984d = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 != 0) {
                if (i3 == 1) {
                    xx0.f.b(this.f114984d);
                }
            } else {
                xx0.f.d(this.f114984d);
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.icgame.game.tim.api.message.a f114986d;

        b(com.tencent.icgame.game.tim.api.message.a aVar) {
            this.f114986d = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            xx0.f.b(this.f114986d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LongClickOperOption[] f114988d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f114989e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.icgame.game.tim.api.message.a f114990f;

        c(LongClickOperOption[] longClickOperOptionArr, Context context, com.tencent.icgame.game.tim.api.message.a aVar) {
            this.f114988d = longClickOperOptionArr;
            this.f114989e = context;
            this.f114990f = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            int i16 = e.f114994a[this.f114988d[i3].ordinal()];
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 == 4) {
                            p.this.c(this.f114989e, this.f114990f);
                        } else if (i16 == 5) {
                            p.this.d(this.f114989e, this.f114990f);
                        }
                    } else {
                        xx0.f.c(this.f114990f);
                    }
                } else {
                    xx0.f.b(this.f114990f);
                }
            } else {
                xx0.f.a(this.f114989e, this.f114990f);
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.icgame.game.tim.api.message.a f114992d;

        d(com.tencent.icgame.game.tim.api.message.a aVar) {
            this.f114992d = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (cy0.c.d() - this.f114992d.time() < 120000) {
                xx0.f.e(this.f114992d);
            } else {
                xx0.f.INSTANCE.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f114994a;

        static {
            int[] iArr = new int[LongClickOperOption.values().length];
            f114994a = iArr;
            try {
                iArr[LongClickOperOption.COPY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f114994a[LongClickOperOption.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f114994a[LongClickOperOption.REPORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f114994a[LongClickOperOption.REVOCATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f114994a[LongClickOperOption.FAVORITE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, com.tencent.icgame.game.tim.api.message.a aVar) {
        if (cy0.c.d() - aVar.time() < 120000) {
            new e.a(context).f("\u662f\u5426\u64a4\u56de\u8be5\u6761\u6d88\u606f?").h(new d(aVar)).c().show();
        } else {
            xx0.f.INSTANCE.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, com.tencent.icgame.game.tim.api.message.a aVar) {
        QBaseActivity b16;
        if (context instanceof QBaseActivity) {
            b16 = (QBaseActivity) context;
        } else {
            b16 = bu0.a.b();
        }
        if (b16 == null) {
            com.tencent.icgame.game.utils.g.d("MessageViewOperator", "doFavorite failed, context:" + context);
            com.tencent.icgame.game.ui.widget.f.c(true, "\u6536\u85cf\u5931\u8d25");
        }
    }

    private String[] e(LongClickOperOption[] longClickOperOptionArr) {
        String[] strArr = new String[longClickOperOptionArr.length];
        for (int i3 = 0; i3 < longClickOperOptionArr.length; i3++) {
            int i16 = e.f114994a[longClickOperOptionArr[i3].ordinal()];
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

    private void i(Context context, com.tencent.icgame.game.tim.api.message.a aVar, String[] strArr, LongClickOperOption[] longClickOperOptionArr, int i3, int i16) {
        new MenuDialog.c(context).b(strArr, new c(longClickOperOptionArr, context, aVar)).a().S(i3, i16);
    }

    public void g(Context context, com.tencent.icgame.game.tim.api.message.a aVar, LongClickOperOption[] longClickOperOptionArr, int i3, int i16) {
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

    public void h(Context context, com.tencent.icgame.game.tim.api.message.a aVar, int i3, int i16) {
        new MenuDialog.c(context).b(new String[]{"\u91cd\u53d1", "\u5220\u9664"}, new a(aVar)).a().S(i3, i16);
    }

    public void f() {
    }
}
