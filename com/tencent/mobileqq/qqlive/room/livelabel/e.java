package com.tencent.mobileqq.qqlive.room.livelabel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends TypeToken<ArrayList<LabelModel>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b extends TypeToken<ArrayList<LabelModel>> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public static LabelModel a() {
        ArrayList<LabelModel> b16 = b();
        if (b16.size() <= 0) {
            return null;
        }
        return b16.get(0);
    }

    public static ArrayList<LabelModel> b() {
        ArrayList<LabelModel> arrayList = (ArrayList) new Gson().fromJson(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE).decodeString("local_cache_key", ""), new b().getType());
        if (arrayList != null) {
            return arrayList;
        }
        return new ArrayList<>();
    }

    public static void c(LabelModel labelModel) {
        if (labelModel == null) {
            return;
        }
        labelModel.isSelected = false;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE);
        ArrayList arrayList = (ArrayList) new Gson().fromJson(from.decodeString("local_cache_key", ""), new a().getType());
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        if (arrayList.contains(labelModel)) {
            arrayList.remove(labelModel);
        }
        arrayList.add(0, labelModel);
        Gson gson = new Gson();
        if (arrayList.size() > 12) {
            from.encodeString("local_cache_key", gson.toJson(arrayList.subList(0, 12)));
        } else {
            from.encodeString("local_cache_key", gson.toJson(arrayList));
        }
    }
}
