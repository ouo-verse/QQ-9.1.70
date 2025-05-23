package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProClientArchive {
    public int clientId;
    public int templateId;
    public String archiveName = "";
    public GProSmobaArchiveTemplate template1 = new GProSmobaArchiveTemplate();
    public GProArchiveTemplate2 template2 = new GProArchiveTemplate2();

    public String getArchiveName() {
        return this.archiveName;
    }

    public int getClientId() {
        return this.clientId;
    }

    public GProSmobaArchiveTemplate getTemplate1() {
        return this.template1;
    }

    public GProArchiveTemplate2 getTemplate2() {
        return this.template2;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public String toString() {
        return "GProClientArchive{clientId=" + this.clientId + ",archiveName=" + this.archiveName + ",templateId=" + this.templateId + ",template1=" + this.template1 + ",template2=" + this.template2 + ",}";
    }
}
