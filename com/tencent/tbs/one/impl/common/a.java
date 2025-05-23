package com.tencent.tbs.one.impl.common;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneConfigurationKeys;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a {
    public static TBSOneRuntimeExtension a(Context context, String str, boolean z16) throws TBSOneException {
        TBSOneManager tBSOneManager = TBSOneManager.getInstance(context, str);
        TBSOneComponent loadedComponent = tBSOneManager.getLoadedComponent(MimeTypeParser.ATTR_EXTENSION);
        if (loadedComponent == null) {
            try {
                if (z16) {
                    File c16 = f.c(f.a(context.getDir("tbs", 0), str));
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("deps", d.a(c16));
                    bundle.putInt("time_out", 30000);
                    loadedComponent = TBSOneManager.getInstance(context, str).loadComponentSync(MimeTypeParser.ATTR_EXTENSION, bundle, 30000L);
                } else {
                    loadedComponent = tBSOneManager.loadComponentSync(MimeTypeParser.ATTR_EXTENSION, 30000L);
                }
            } catch (TBSOneException e16) {
                throw new TBSOneException(503, "Failed to load runtime extension, error: [" + e16.getErrorCode() + "] " + e16.getMessage(), e16.getCause());
            }
        }
        if (loadedComponent != null) {
            if (loadedComponent.getEntryObject() instanceof TBSOneRuntimeExtension) {
                return (TBSOneRuntimeExtension) loadedComponent.getEntryObject();
            }
            throw new TBSOneException(504, "Failed to cast the entry object of runtime extension");
        }
        throw new TBSOneException(509, "Failed to load runtime extension, unexpected nullpointer return");
    }

    public static TBSOneRuntimeExtension a(Context context, String str) {
        TBSOneComponent loadedComponent = TBSOneManager.getInstance(context, str).getLoadedComponent(MimeTypeParser.ATTR_EXTENSION);
        if (loadedComponent == null || !(loadedComponent.getEntryObject() instanceof TBSOneRuntimeExtension)) {
            return null;
        }
        return (TBSOneRuntimeExtension) loadedComponent.getEntryObject();
    }

    public static void a(Context context, final TBSOneCallback<TBSOneDebugPlugin> tBSOneCallback, TBSOneManager.Policy policy) {
        TBSOneManager tBSOneManager = TBSOneManager.getInstance(context, "debug");
        if (policy != null) {
            tBSOneManager.setPolicy(policy);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(TBSOneConfigurationKeys.IGNORE_FLOW_CONTROL_SUGGESTION, true);
        bundle.putBoolean(TBSOneConfigurationKeys.IGNORE_WIFI_STATE, true);
        tBSOneManager.loadComponentAsync("debugger", bundle, new TBSOneCallback<TBSOneComponent>() { // from class: com.tencent.tbs.one.impl.common.a.1
            @Override // com.tencent.tbs.one.TBSOneCallback
            public final /* synthetic */ void onCompleted(TBSOneComponent tBSOneComponent) {
                Object entryObject = tBSOneComponent.getEntryObject();
                if (entryObject instanceof TBSOneDebugPlugin) {
                    TBSOneCallback.this.onCompleted((TBSOneDebugPlugin) entryObject);
                } else {
                    TBSOneCallback.this.onError(505, "Failed to cast the entry object of debug plugin");
                }
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onError(int i3, String str) {
                super.onError(i3, str);
                com.tencent.tbs.one.impl.a.g.c("Failed to load debug plugin, code: " + i3 + ", detail: " + str, new Object[0]);
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onProgressChanged(int i3, int i16) {
                super.onProgressChanged(i3, i16);
                com.tencent.tbs.one.impl.a.g.c("Loading debug plugin, " + i3 + " -> " + i16, new Object[0]);
            }
        });
    }
}
