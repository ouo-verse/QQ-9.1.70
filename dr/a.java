package dr;

import com.tencent.qcircle.tavcut.bean.Size;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes38.dex */
class a implements d {
    @Override // dr.d
    public int a() {
        return QzoneConfig.getAEExportFrameRate();
    }

    @Override // dr.d
    public Size b(Size size) {
        int intValue = ((Integer) c.d(Integer.valueOf(QzoneConfig.getAELowSize()), Integer.valueOf(QzoneConfig.getAEMiddleSize()), Integer.valueOf(QzoneConfig.getAEHighSize()))).intValue();
        Size size2 = new Size(0, 0);
        double width = size.getWidth() / size.getHeight();
        if (size.getWidth() > size.getHeight()) {
            size2.setWidth(Math.min(size.getWidth(), intValue));
            size2.setHeight(c.f(size2.getWidth() / width));
        } else {
            size2.setHeight(Math.min(size.getHeight(), intValue));
            size2.setWidth(c.f(size2.getHeight() * width));
        }
        return size2;
    }

    @Override // dr.d
    public int c() {
        return ((Integer) c.d(Integer.valueOf(QzoneConfig.getAELowSize()), Integer.valueOf(QzoneConfig.getAEMiddleSize()), Integer.valueOf(QzoneConfig.getAEHighSize()))).intValue();
    }

    @Override // dr.d
    public int d() {
        return ((Integer) c.d(Integer.valueOf(QzoneConfig.getAELowBitRate() * 1048576), Integer.valueOf(QzoneConfig.getAEMiddleBitRate() * 1048576), Integer.valueOf(QzoneConfig.getAEHighBitRate() * 1048576))).intValue();
    }
}
