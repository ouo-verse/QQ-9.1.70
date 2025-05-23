package cooperation.vip.AdvVideoFloat;

/* loaded from: classes28.dex */
public class AdvGerneralProxy implements IAdvGerneralVideo {
    private static AdvGerneralProxy mInstance;
    private IAdvGerneralVideo mEngineImpl;

    public static synchronized AdvGerneralProxy getInstance() {
        AdvGerneralProxy advGerneralProxy;
        synchronized (AdvGerneralProxy.class) {
            if (mInstance == null) {
                mInstance = new AdvGerneralProxy();
            }
            advGerneralProxy = mInstance;
        }
        return advGerneralProxy;
    }

    @Override // cooperation.vip.AdvVideoFloat.IAdvGerneralVideo
    public String getCallBackData(String str) {
        IAdvGerneralVideo iAdvGerneralVideo = this.mEngineImpl;
        if (iAdvGerneralVideo != null) {
            return iAdvGerneralVideo.getCallBackData(str);
        }
        return null;
    }

    @Override // cooperation.vip.AdvVideoFloat.IAdvGerneralVideo
    public int getFirstKey() {
        IAdvGerneralVideo iAdvGerneralVideo = this.mEngineImpl;
        if (iAdvGerneralVideo != null) {
            return iAdvGerneralVideo.getFirstKey();
        }
        return 0;
    }

    @Override // cooperation.vip.AdvVideoFloat.IAdvGerneralVideo
    public int getFourthKey() {
        IAdvGerneralVideo iAdvGerneralVideo = this.mEngineImpl;
        if (iAdvGerneralVideo != null) {
            return iAdvGerneralVideo.getFourthKey();
        }
        return 0;
    }

    @Override // cooperation.vip.AdvVideoFloat.IAdvGerneralVideo
    public int getSecondKey() {
        IAdvGerneralVideo iAdvGerneralVideo = this.mEngineImpl;
        if (iAdvGerneralVideo != null) {
            return iAdvGerneralVideo.getSecondKey();
        }
        return 0;
    }

    @Override // cooperation.vip.AdvVideoFloat.IAdvGerneralVideo
    public void notifyH5PageReady(String str) {
        IAdvGerneralVideo iAdvGerneralVideo = this.mEngineImpl;
        if (iAdvGerneralVideo != null) {
            iAdvGerneralVideo.notifyH5PageReady(str);
        }
    }

    @Override // cooperation.vip.AdvVideoFloat.IAdvGerneralVideo
    public void notifyOnlyReportClick(String str) {
        IAdvGerneralVideo iAdvGerneralVideo = this.mEngineImpl;
        if (iAdvGerneralVideo != null) {
            iAdvGerneralVideo.notifyOnlyReportClick(str);
        }
    }

    @Override // cooperation.vip.AdvVideoFloat.IAdvGerneralVideo
    public void notifyOnlyReportClickArea(int i3) {
        IAdvGerneralVideo iAdvGerneralVideo = this.mEngineImpl;
        if (iAdvGerneralVideo != null) {
            iAdvGerneralVideo.notifyOnlyReportClickArea(i3);
        }
    }

    @Override // cooperation.vip.AdvVideoFloat.IAdvGerneralVideo
    public void notifyVideoBlankClick(String str) {
        IAdvGerneralVideo iAdvGerneralVideo = this.mEngineImpl;
        if (iAdvGerneralVideo != null) {
            iAdvGerneralVideo.notifyVideoBlankClick(str);
        }
    }

    public void setmEngineImpl(IAdvGerneralVideo iAdvGerneralVideo) {
        this.mEngineImpl = iAdvGerneralVideo;
    }
}
