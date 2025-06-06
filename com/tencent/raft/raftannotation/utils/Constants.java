package com.tencent.raft.raftannotation.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class Constants {
    static IPatchRedirector $redirector_ = null;
    public static final String DEFAULT_GLOBAL_CONFIG_TARGET = "DefaultGlobalTarget";
    public static final String NAME_OF_AUTO_WIRED = "RAFT$$AutoWired$$";
    public static final String NAME_OF_BEAN_TARGET = "RAFT$$Target$$";
    public static final String PACKAGE_OF_GENERATE_FILE = "com.tencent.raft.codegenerator.generator.annotation";
    public static final String PACKAGE_OF_GENERATE_YAML_FILE = "com.tencent.raft.codegenerator.generator.yaml";
    public static final String PREFIX_OF_LOGGER = "RAFT::Compiler ";
    public static final String PROJECT = "RAFT";
    public static final String RAFT_YAML_FILE = "com_raft.yaml";
    public static final String SEPARATOR = "$$";
    public static final String TAG = "RAFT::";
    public static final String WARNING_TIPS = " IT WAS GENERATED BY RAFT. DO NOT EDIT THIS FILE!!!";

    public Constants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
