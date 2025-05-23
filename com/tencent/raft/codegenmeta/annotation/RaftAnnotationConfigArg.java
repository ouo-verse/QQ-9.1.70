package com.tencent.raft.codegenmeta.annotation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.Set;
import javax.lang.model.element.Modifier;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RaftAnnotationConfigArg implements Serializable {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = 1001;
    public String argMethod;
    public String argName;
    public String configClassName;
    public String configMethodName;
    public Set<Modifier> modifier;
    public String returnType;

    public RaftAnnotationConfigArg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "RaftAnnotationConfigArg{configClassName='" + this.configClassName + "', configMethodName='" + this.configMethodName + "', argMethod='" + this.argMethod + "', argName='" + this.argName + "', modifier=" + this.modifier + ", returnType='" + this.returnType + "'}";
    }
}
