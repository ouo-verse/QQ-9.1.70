package com.tencent.mobileqq.tbstool.web.jshandler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/tbstool/web/jshandler/f;", "Lcom/tencent/mobileqq/tbstool/web/jshandler/a;", "Lorg/json/JSONObject;", "args", "a", "", "b", "()Ljava/lang/String;", "handleMethodName", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f extends a {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tbstool.web.jshandler.a
    @Nullable
    public JSONObject a(@NotNull JSONObject args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JSONObject) iPatchRedirector.redirect((short) 3, (Object) this, (Object) args);
        }
        Intrinsics.checkNotNullParameter(args, "args");
        JSONArray optJSONArray = args.optJSONArray("pathList");
        if (optJSONArray == null) {
            return null;
        }
        if (optJSONArray.length() <= 0) {
            QLog.d("ShareFileHandler", 1, "empty path");
            return null;
        }
        int length = optJSONArray.length();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < length; i3++) {
            String optString = optJSONArray.optString(i3);
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(optString);
            }
        }
        EIPCClient client = QIPCClientHelper.getInstance().getClient();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("pathList", arrayList);
        Unit unit = Unit.INSTANCE;
        BinderMethodProxy.callServer(client, "TBSToolIPCModule", "sendFile", bundle);
        return null;
    }

    @Override // com.tencent.mobileqq.tbstool.web.jshandler.a
    @NotNull
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "sendFile";
    }
}
