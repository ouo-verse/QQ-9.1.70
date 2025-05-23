package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CheckInfo {
    static IPatchRedirector $redirector_;
    private final String action;
    private int callbackId;
    private final Context context;
    private final Intent intent;
    private final String packageName;
    private final String refID;
    private final List<ResolveInfo> resolveInfos;
    private final String scheme;
    private final String sourceID;
    private final JefsClass.CancelableRunnable torun;
    private final String url;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class CheckInfoBuilder {
        static IPatchRedirector $redirector_;
        private String action;
        private int callbackId;
        private Context context;
        private Intent intent;
        private String packageName;
        private String refID;
        private List<ResolveInfo> resolveInfos;
        private String scheme;
        private String sourceID;
        private JefsClass.CancelableRunnable torun;
        private String url;

        public CheckInfoBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this);
            }
        }

        public CheckInfo build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (CheckInfo) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return new CheckInfo(this, null);
        }

        @NonNull
        public CheckInfoBuilder setAction(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (CheckInfoBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            }
            this.action = str;
            return this;
        }

        public CheckInfoBuilder setCallbackId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (CheckInfoBuilder) iPatchRedirector.redirect((short) 10, (Object) this, i3);
            }
            this.callbackId = i3;
            return this;
        }

        @NonNull
        public CheckInfoBuilder setContext(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (CheckInfoBuilder) iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
            this.context = context;
            return this;
        }

        @NonNull
        public CheckInfoBuilder setIntent(Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CheckInfoBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            }
            this.intent = intent;
            return this;
        }

        @NonNull
        public CheckInfoBuilder setPackageName(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (CheckInfoBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.packageName = str;
            return this;
        }

        @NonNull
        public CheckInfoBuilder setRefID(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (CheckInfoBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.refID = str;
            return this;
        }

        @NonNull
        public CheckInfoBuilder setResolveInfos(List<ResolveInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (CheckInfoBuilder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
            }
            this.resolveInfos = list;
            return this;
        }

        @NonNull
        public CheckInfoBuilder setScheme(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (CheckInfoBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.scheme = str;
            return this;
        }

        @NonNull
        public CheckInfoBuilder setSourceID(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (CheckInfoBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.sourceID = str;
            return this;
        }

        @NonNull
        public CheckInfoBuilder setTorun(JefsClass.CancelableRunnable cancelableRunnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (CheckInfoBuilder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) cancelableRunnable);
            }
            this.torun = cancelableRunnable;
            return this;
        }

        @NonNull
        public CheckInfoBuilder setUrl(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (CheckInfoBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.url = str;
            return this;
        }
    }

    /* synthetic */ CheckInfo(CheckInfoBuilder checkInfoBuilder, AnonymousClass1 anonymousClass1) {
        this(checkInfoBuilder);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) checkInfoBuilder, (Object) anonymousClass1);
    }

    @Nullable
    public String getAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.action;
    }

    public int getCallbackId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.callbackId;
    }

    @NonNull
    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Context) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.context;
    }

    @NonNull
    public Intent getIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Intent) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.intent;
    }

    @Nullable
    public String getPackageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.packageName;
    }

    public String getRefID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.refID;
    }

    @Nullable
    public List<ResolveInfo> getResolveInfos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.resolveInfos;
    }

    @Nullable
    public String getScheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.scheme;
    }

    public String getSourceID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.sourceID;
    }

    @NonNull
    public JefsClass.CancelableRunnable getTorun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (JefsClass.CancelableRunnable) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.torun;
    }

    @Nullable
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.url;
    }

    public void setCallbackId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.callbackId = i3;
        }
    }

    CheckInfo(CheckInfoBuilder checkInfoBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) checkInfoBuilder);
            return;
        }
        this.context = checkInfoBuilder.context;
        this.intent = checkInfoBuilder.intent;
        this.sourceID = checkInfoBuilder.sourceID;
        this.refID = checkInfoBuilder.refID;
        this.url = checkInfoBuilder.url;
        this.packageName = checkInfoBuilder.packageName;
        this.scheme = checkInfoBuilder.scheme;
        this.action = checkInfoBuilder.action;
        this.resolveInfos = checkInfoBuilder.resolveInfos;
        this.callbackId = checkInfoBuilder.callbackId;
        this.torun = checkInfoBuilder.torun;
    }
}
