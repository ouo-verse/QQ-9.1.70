package com.tencent.mobileqq.selectmember.troop;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$CheckGroupsRsp;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Function1<com.tencent.mobileqq.selectmember.troop.repo.f, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f286022d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f286023e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f286024f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ArrayList f286025h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Map f286026i;

        a(i iVar, Context context, String str, ArrayList arrayList, Map map) {
            this.f286022d = iVar;
            this.f286023e = context;
            this.f286024f = str;
            this.f286025h = arrayList;
            this.f286026i = map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, iVar, context, str, arrayList, map);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(com.tencent.mobileqq.selectmember.troop.repo.f fVar) {
            TroopJoinQunAutoSwitch$CheckGroupsRsp b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            }
            QLog.d("SelectTroopListChecker", 1, "checkSelectedGroups onSuccess");
            try {
                this.f286022d.b();
                b16 = fVar.b();
            } catch (Exception e16) {
                QLog.e("SelectTroopListChecker", 1, "checkSelectedGroups merge pb error.", e16);
            }
            if (b16 == null) {
                b.f(this.f286023e, this.f286024f, this.f286025h, this.f286022d);
                return null;
            }
            b.l(this.f286023e, this.f286024f, this.f286025h, this.f286026i, b16.binded_groups.get(), b16.name_wrong_group.get(), b16.source_groups.get(), b16.binded_master_groups.get(), this.f286022d);
            return null;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.selectmember.troop.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class C8572b implements Function3<com.tencent.mobileqq.selectmember.troop.repo.f, Integer, String, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f286027d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f286028e;

        C8572b(i iVar, Context context) {
            this.f286027d = iVar;
            this.f286028e = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iVar, (Object) context);
            }
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(com.tencent.mobileqq.selectmember.troop.repo.f fVar, Integer num, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, this, fVar, num, str);
            }
            QLog.d("SelectTroopListChecker", 1, "checkSelectedGroups onError");
            this.f286027d.b();
            if (TextUtils.isEmpty(str)) {
                str = "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u91cd\u8bd5";
            }
            QQToast.makeText(this.f286028e, 1, str, 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f286029d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f286030e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f286031f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ArrayList f286032h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Map f286033i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ i f286034m;

        c(List list, Context context, String str, ArrayList arrayList, Map map, i iVar) {
            this.f286029d = list;
            this.f286030e = context;
            this.f286031f = str;
            this.f286032h = arrayList;
            this.f286033i = map;
            this.f286034m = iVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, list, context, str, arrayList, map, iVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.d("SelectTroopListChecker", 1, "showNotSupportGroupDialog onClick");
            if (b.i(this.f286029d)) {
                b.j(this.f286030e, this.f286031f, this.f286032h, this.f286033i, this.f286029d, this.f286034m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f286035d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f286036e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f286037f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f286038h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ i f286039i;

        d(Context context, String str, ArrayList arrayList, List list, i iVar) {
            this.f286035d = context;
            this.f286036e = str;
            this.f286037f = arrayList;
            this.f286038h = list;
            this.f286039i = iVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, str, arrayList, list, iVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.d("SelectTroopListChecker", 1, "showAddedSourceGroupDialog onClick which = " + i3);
            if (i3 == 1) {
                b.h(this.f286035d, this.f286036e, this.f286037f, this.f286038h, this.f286039i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e implements Function1<byte[], Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f286040d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f286041e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f286042f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ i f286043h;

        e(Context context, String str, ArrayList arrayList, i iVar) {
            this.f286040d = context;
            this.f286041e = str;
            this.f286042f = arrayList;
            this.f286043h = iVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, str, arrayList, iVar);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
            }
            QLog.d("SelectTroopListChecker", 1, "clearSelectedGroupSource onSuccess");
            b.f(this.f286040d, this.f286041e, this.f286042f, this.f286043h);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f implements Function2<Integer, String, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f286044d;

        f(Context context) {
            this.f286044d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Integer num, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) num, (Object) str);
            }
            QLog.d("SelectTroopListChecker", 1, "clearSelectedGroupSource onError");
            if (TextUtils.isEmpty(str)) {
                str = "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u91cd\u8bd5";
            }
            QQToast.makeText(this.f286044d, 1, str, 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g implements Function1<byte[], Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f286045d;

        g(i iVar) {
            this.f286045d = iVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iVar);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
            }
            QLog.d("SelectTroopListChecker", 1, "clearSelectedGroupSource onSuccess");
            this.f286045d.a(bArr);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class h implements Function2<Integer, String, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f286046d;

        h(Context context) {
            this.f286046d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Integer num, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) num, (Object) str);
            }
            if (TextUtils.isEmpty(str)) {
                str = "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u91cd\u8bd5";
            }
            QQToast.makeText(this.f286046d, 1, str, 0).show();
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface i {
        void a(byte[] bArr);

        void b();

        void c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context, String str, ArrayList<ResultRecord> arrayList, i iVar) {
        try {
            com.tencent.mobileqq.selectmember.troop.repo.c.a(str, arrayList, new g(iVar), new h(context));
        } catch (Exception unused) {
            QLog.d("SelectTroopListChecker", 1, "addSubGroups json error.");
        }
    }

    public static void g(Context context, String str, String str2, ArrayList<ResultRecord> arrayList, i iVar) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(str, str2);
        }
        Iterator<ResultRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            ResultRecord next = it.next();
            hashMap.put(next.uin, next.name);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<ResultRecord> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(it5.next().uin);
        }
        iVar.c();
        com.tencent.mobileqq.selectmember.troop.repo.c.b(str, arrayList2, new a(iVar, context, str, arrayList, hashMap), new C8572b(iVar, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Context context, String str, ArrayList<ResultRecord> arrayList, List<String> list, i iVar) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Long.valueOf(Long.parseLong(it.next())));
            }
            com.tencent.mobileqq.selectmember.troop.repo.c.c(arrayList2, new e(context, str, arrayList, iVar), new f(context));
            return;
        }
        QLog.d("SelectTroopListChecker", 1, "clearSelectedGroupSource source groups is empty.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean i(List<String> list) {
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Context context, String str, ArrayList<ResultRecord> arrayList, Map<String, String> map, List<String> list, i iVar) {
        if (list != null && list.size() > 0) {
            StringBuilder sb5 = new StringBuilder("\u4ee5\u4e0b\u7fa4\u5df2\u8bbe\u7f6e\u7fa4\u6765\u6e90:");
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                sb5.append(map.get(list.get(i3)));
                if (i3 < size - 1) {
                    sb5.append("\u3001");
                }
            }
            if (sb5.length() > 0) {
                sb5.append(", \u82e5\u7ee7\u7eed\u8bbe\u7f6e\u5907\u9009\u7fa4\uff0c\u6240\u9009\u7fa4\u5df2\u8bbe\u7f6e\u7684\u6765\u6e90\u5c06\u88ab\u6e05\u9664\uff0c\u662f\u5426\u786e\u8ba4\u7ee7\u7eed\u9009\u62e9");
                k(context, "\u7fa4\u5df2\u8bbe\u7f6e\u6765\u6e90", sb5.toString(), "\u786e\u5b9a", "\u53d6\u6d88", 2, new d(context, str, arrayList, list, iVar));
                return;
            }
            return;
        }
        QLog.d("SelectTroopListChecker", 1, "showAddedSourceGroupDialog list is empty");
        f(context, str, arrayList, iVar);
    }

    private static void k(Context context, String str, String str2, String str3, String str4, int i3, DialogInterface.OnClickListener onClickListener) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230);
        createCustomDialog.setTitle(str);
        createCustomDialog.setMessage(str2);
        createCustomDialog.setPositiveButton(str3, onClickListener);
        if (i3 == 2) {
            createCustomDialog.setNegativeButton(str4, onClickListener);
        }
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(Context context, String str, ArrayList<ResultRecord> arrayList, Map<String, String> map, List<String> list, List<String> list2, List<String> list3, List<String> list4, i iVar) {
        StringBuilder sb5 = new StringBuilder();
        if (!i(list) && !i(list2) && !i(list4)) {
            j(context, str, arrayList, map, list3, iVar);
            return;
        }
        if (list2 != null && list2.size() > 0) {
            int size = list2.size();
            for (int i3 = 0; i3 < size; i3++) {
                sb5.append(map.get(list2.get(i3)));
                if (i3 < size - 1) {
                    sb5.append("\u3001");
                }
            }
            sb5.append(":\u4e0d\u7b26\u5408\u547d\u540d\u89c4\u8303;");
        }
        if (list != null && list.size() > 0) {
            int size2 = list.size();
            for (int i16 = 0; i16 < size2; i16++) {
                sb5.append(map.get(list.get(i16)));
                if (i16 < size2 - 1) {
                    sb5.append("\u3001");
                }
            }
            sb5.append(":\u5df2\u88ab\u7fa4\u4e3b\u7ed1\u5b9a;");
        }
        if (list4 != null && list4.size() > 0) {
            int size3 = list4.size();
            for (int i17 = 0; i17 < size3; i17++) {
                sb5.append(map.get(list4.get(i17)));
                if (i17 < size3 - 1) {
                    sb5.append("\u3001");
                }
            }
            sb5.append(":\u5df2\u4f5c\u4e3a\u4e3b\u7fa4\u88ab\u7ed1\u5b9a;");
        }
        if (sb5.length() > 0) {
            sb5.append("\u8bf7\u5bf9\u8fd9\u4e9b\u7fa4\u624b\u52a8\u53d6\u6d88\u52fe\u9009");
            k(context, "\u90e8\u5206\u7fa4\u4e0d\u652f\u6301\u52fe\u9009", sb5.toString(), "\u6211\u77e5\u9053\u4e86", "", 1, new c(list3, context, str, arrayList, map, iVar));
        }
    }
}
